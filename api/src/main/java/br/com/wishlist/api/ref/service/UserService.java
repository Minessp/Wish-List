package br.com.wishlist.api.service;

import br.com.wishlist.api.dto.users.*;
import br.com.wishlist.api.exceptions.InvalidFieldValue;
import br.com.wishlist.api.exceptions.PasswordNotMatchException;
import br.com.wishlist.api.exceptions.UserAlreadyExistException;
import br.com.wishlist.api.model.User;
import br.com.wishlist.api.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Impossibilita reversão via hash
    }

    public List<UserResponse> listAllUsers() {
        return userRepository.findAll().stream().map(user -> UserResponse
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getAuthorities().stream().findFirst().map(
                                GrantedAuthority::getAuthority).orElse(""))
                .build()).collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found using id: " + id);
        }

        return UserResponse
                .builder()
                .id(userRepository.getUserById(id).getId())
                .username(userRepository.getUserById(id).getUsername())
                .email(userRepository.getUserById(id).getEmail())
                .role(userRepository.getUserById(id).getAuthorities().stream().findFirst().map(
                        GrantedAuthority::getAuthority).orElse(""))
                .build();
    }

    public CreateUserResponse signUp(CreateUserRequest user) throws UserAlreadyExistException {
        if (userRepository.findUserByEmail(user.email()) != null
                || userRepository.findUserByUsername(user.username()) != null) {
            throw new UserAlreadyExistException();
        }

        String encodedPassword = passwordEncoder.encode(user.password());
        userRepository.save(new User(user.username(), user.email(), encodedPassword, user.role()));
        return CreateUserResponse
                .builder()
                .username(user.username())
                .email(user.email())
                .role(user.role())
                .build();
    }

    public UserResponse updateUser(UpdateUserRequest user) {
        User currentUser = userRepository.getUserById(user.id());

         if(!passwordEncoder.matches(user.password(), currentUser.getPassword())){
             throw new PasswordNotMatchException();
         }

        if(user.fieldValue() != null && !user.fieldValue().trim().isEmpty()){
            try {
                String methodName = "set" + user.field().substring(0, 1).toUpperCase() +
                        user.field().substring(1);

                Method setterName = User.class.getMethod(methodName, String.class);

                if(user.fieldValue().equals("password")) {
                    String passwordEncoded = passwordEncoder.encode(user.password());
                    setterName.invoke(currentUser, passwordEncoded);
                }

                setterName.invoke(currentUser, user.fieldValue());
                userRepository.save(currentUser);

                return UserResponse
                        .builder()
                        .id(currentUser.getId())
                        .username(currentUser.getUsername())
                        .email(currentUser.getEmail())
                        .role(currentUser.getAuthorities().stream().findFirst().map(
                                GrantedAuthority::getAuthority).orElse(""))
                        .build();
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

        userRepository.delete(userRepository.getUserById(id));
    }
}
