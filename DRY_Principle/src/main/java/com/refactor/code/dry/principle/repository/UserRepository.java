package com.refactor.code.dry.principle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.refactor.code.dry.principle.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
