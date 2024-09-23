package com.glchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glchallenge.model.Phone;

@Repository
public interface IPhoneRepository  extends JpaRepository<Phone, Long> {

}
