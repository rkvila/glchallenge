package com.glchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glchallenge.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}