/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repcar.workshop.beans.Workshop;

/**
 * Home object for domain model class Workshop.
 *
 */
@Repository
@Qualifier("workshopDAO")
public interface WorkshopDAO extends JpaRepository<Workshop, Long> {

	Workshop findByWorkshopName(String workshopname);

    Page<Workshop> findByWorkshopId(Long workshopId, Pageable pageable);
}
