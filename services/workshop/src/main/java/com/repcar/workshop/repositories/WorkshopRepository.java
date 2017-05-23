/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.repcar.workshop.beans.User;
import com.repcar.workshop.beans.Workshop;

/**
 * Home object for domain model class Workshop.
 *
 */
@Repository
@Transactional
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {

	Workshop findByWorkshopName(String workshopName);

    Page<Workshop> findByWorkshopId(Long workshopId, Pageable pageable);
}
