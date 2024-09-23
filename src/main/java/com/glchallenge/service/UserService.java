package com.glchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glchallenge.model.User;
import com.glchallenge.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepo;
		
	@Override
	public void saveUser(User user) {
		userRepo.save(user);
	}

	@Override
	public User findUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public User findUserByToken(Long token) {
		return userRepo.findById(token).orElse(null); // TODO implementar JWT
	}

}
