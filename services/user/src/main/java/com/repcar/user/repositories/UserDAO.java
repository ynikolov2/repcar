/*
 * Copyright RepCar AD 2017
 */
package com.repcar.user.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.repcar.user.beans.User;

/**
 * Home object for domain model class User.
 *
 */
@Repository
@Qualifier("userDAO")
public interface UserDAO extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Page<User> findByWorkshopId(Long companyId, Pageable pageable);
}
