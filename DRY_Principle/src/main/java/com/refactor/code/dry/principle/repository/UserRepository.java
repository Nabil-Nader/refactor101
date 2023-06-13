package com.refactor.code.dry.principle.repository;

import com.refactor.code.dry.principle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
