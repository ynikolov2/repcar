package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Services.
 * @see com.repcar.makemodel.Services
 * @author Hibernate Tools
 */
@Stateless
public class ServicesHome {

	private static final Log log = LogFactory.getLog(ServicesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Services transientInstance) {
		log.debug("persisting Services instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Services persistentInstance) {
		log.debug("removing Services instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Services merge(Services detachedInstance) {
		log.debug("merging Services instance");
		try {
			Services result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Services findById(Integer id) {
		log.debug("getting Services instance with id: " + id);
		try {
			Services instance = entityManager.find(Services.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
