package br.com.wishlist.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiWishListApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiWishListApplication.class, args);
	}
}
