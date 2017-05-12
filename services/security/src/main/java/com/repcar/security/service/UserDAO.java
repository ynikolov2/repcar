/*
 * Copyright RepCar AD 2017
 */
package com.repcar.security.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.repcar.security.model.User;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
