package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class WorshopServices.
 * @see com.repcar.makemodel.WorshopServices
 * @author Hibernate Tools
 */
@Stateless
public class WorshopServicesHome {

	private static final Log log = LogFactory.getLog(WorshopServicesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(WorshopServices transientInstance) {
		log.debug("persisting WorshopServices instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(WorshopServices persistentInstance) {
		log.debug("removing WorshopServices instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public WorshopServices merge(WorshopServices detachedInstance) {
		log.debug("merging WorshopServices instance");
		try {
			WorshopServices result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorshopServices findById(Integer id) {
		log.debug("getting WorshopServices instance with id: " + id);
		try {
			WorshopServices instance = entityManager.find(WorshopServices.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
