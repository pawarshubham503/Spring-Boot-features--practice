package io.getarrays.userservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
CommandLineRunner  run(UserService userService) {
	return ars->{
	userService.saveRole(new Role(null,"ROLE_USER"));	
	userService.saveRole(new Role(null,"ROLE_MANAGER"));
	userService.saveRole(new Role(null,"ROLE_ADMIN"));
	userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
	
	userService.saveUser(new User(null,"Shubham Pawar","shubham","1234",new ArrayList<>()));
	userService.saveUser(new User(null,"Rio Smith","rio","1234",new ArrayList<>()));
	userService.saveUser(new User(null,"Wally Swiftr","wally","1234",new ArrayList<>()));
	userService.saveUser(new User(null,"Rowdy Santa","rowdy","1234",new ArrayList<>()));
	
	userService.addRoleToUser("shubham","ROLE_USER");
	userService.addRoleToUser("shubham","ROLE_MANAGER");
	userService.addRoleToUser("rio","ROLE_MANAGER");
	userService.addRoleToUser("wally","ROLE_ADMIN");
	userService.addRoleToUser("rowdy","ROLE_SUPER_ADMIN");
	userService.addRoleToUser("rowdy","ROLE_MANAGER");
	userService.addRoleToUser("rowdy","ROLE_USER");
	
	};
}
}
