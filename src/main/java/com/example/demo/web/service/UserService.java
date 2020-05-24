package com.example.demo.web.service;

import com.example.demo.core.jpa.domain.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
