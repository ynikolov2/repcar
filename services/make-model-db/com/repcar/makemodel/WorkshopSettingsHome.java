package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class WorkshopSettings.
 * @see com.repcar.makemodel.WorkshopSettings
 * @author Hibernate Tools
 */
@Stateless
public class WorkshopSettingsHome {

	private static final Log log = LogFactory.getLog(WorkshopSettingsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(WorkshopSettings transientInstance) {
		log.debug("persisting WorkshopSettings instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(WorkshopSettings persistentInstance) {
		log.debug("removing WorkshopSettings instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public WorkshopSettings merge(WorkshopSettings detachedInstance) {
		log.debug("merging WorkshopSettings instance");
		try {
			WorkshopSettings result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkshopSettings findById(Integer id) {
		log.debug("getting WorkshopSettings instance with id: " + id);
		try {
			WorkshopSettings instance = entityManager.find(WorkshopSettings.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
