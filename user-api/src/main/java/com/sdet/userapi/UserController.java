package com.sdet.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

	@GetMapping("/users/1")
	public Map<String, Object> getUser() {

		return Map.of(
				"id", 1,
				"name", "Vishnu",
				"username", "vishnu",
				"email", "vishnu@example.com"
		);
	}
}