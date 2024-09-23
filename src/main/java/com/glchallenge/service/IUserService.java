package com.glchallenge.service;

import com.glchallenge.model.User;

public interface IUserService {

	public void saveUser(User user);
	
	public User findUser(Long id);

	public User findUserByToken(Long token);
	
}
