/*
 * Copyright RepCar AD 2017
 */
package com.repcar.security.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.repcar.security.model.User;
import com.repcar.security.model.UserRole;

@Repository
@Transactional
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {
    User getByRoleId(Long roleId);
}
