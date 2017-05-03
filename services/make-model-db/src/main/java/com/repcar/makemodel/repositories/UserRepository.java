/*
 * Copyright RepCar AD 2017
 */
package com.repcar.makemodel.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.repcar.makemodel.beans.User_old;

/**
 * Home object for domain model class User_old.
 * 
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User_old, Long> {

    User_old findByUserName(String userName);

    Page<User_old> findByCompanyId(Long companyId, Pageable pageable);
}
