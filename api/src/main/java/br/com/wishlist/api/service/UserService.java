package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.users.UpdateUserRequestDto;
import br.com.wishlist.api.dto.users.UserDto;
import br.com.wishlist.api.exceptions.InvalidFieldValue;
import br.com.wishlist.api.exceptions.PasswordNotMatchException;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.service.annotation.HttpExchange;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Impossibilita reversão via hash
    }

    public List<UserDto> listAllUsers() {
        return userRepository.findAll().stream().map(user -> new UserDto(user.getId(), user.getUsername(),
                        user.getEmail(), user.getAuthorities().stream().findFirst().map(
                                GrantedAuthority::getAuthority).orElse("")))
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found using id: " + id);
        }

        User user = userRepository.getUserById(id);

        return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getAuthorities().stream().findFirst().map(
                GrantedAuthority::getAuthority).orElse(""));
    }

    public UserDto signUp(UserDto userDto) throws UserAlreadyExistException {
        if (userRepository.findUserByEmail(userDto.email()) != null
                || userRepository.findUserByUsername(userDto.username()) != null) {
            throw new UserAlreadyExistException();
        }

        String encodedPassword = passwordEncoder.encode(userDto.password());
        userRepository.save(new User(userDto.username(), userDto.email(), encodedPassword, userDto.role()));
        return new UserDto(userDto.username(), userDto.email(), userDto.role());
    }

    public UserDto updateUser(UpdateUserRequestDto request) {
        User user = userRepository.getUserById(request.id());

         if(!passwordEncoder.matches(request.password(), user.getPassword())){
             throw new PasswordNotMatchException();
         }

        if(request.fieldValue() != null && !request.fieldValue().trim().isEmpty()){
            try {
                String methodName = "set" + request.field().substring(0, 1).toUpperCase() +
                        request.field().substring(1);

                Method setterName = User.class.getMethod(methodName, String.class);

                if(request.fieldValue().equals("password")) {
                    String passwordEncoded = passwordEncoder.encode(request.password());
                    setterName.invoke(user, passwordEncoded);
                }

                setterName.invoke(user, request.fieldValue());
                userRepository.save(user);
                return new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getAuthorities().stream().findFirst().map(
                        GrantedAuthority::getAuthority).orElse(""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        throw new InvalidFieldValue();
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found using id: " + id);
        }

        User user = userRepository.getUserById(id);
        userRepository.delete(user);
    }
}
