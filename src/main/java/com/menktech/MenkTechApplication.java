package com.menktech;

import com.menktech.entity.Role;
import com.menktech.entity.User;
import com.menktech.permissions.PermissionEnum;
import com.menktech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MenkTechApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MenkTechApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");

		List<Role> roles = new ArrayList<>();

		Role adminRole = new Role();
		adminRole.setName(PermissionEnum.ADMIN);

		Role userRole = new Role();
		userRole.setName(PermissionEnum.USER);

		roles.add(adminRole);
		roles.add(userRole);

		user.setRoles(roles);

		userService.addUser(user);


	}
}
