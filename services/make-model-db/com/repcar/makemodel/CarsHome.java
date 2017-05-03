package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Cars.
 * @see com.repcar.makemodel.Cars
 * @author Hibernate Tools
 */
@Stateless
public class CarsHome {

	private static final Log log = LogFactory.getLog(CarsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Cars transientInstance) {
		log.debug("persisting Cars instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Cars persistentInstance) {
		log.debug("removing Cars instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Cars merge(Cars detachedInstance) {
		log.debug("merging Cars instance");
		try {
			Cars result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cars findById(Integer id) {
		log.debug("getting Cars instance with id: " + id);
		try {
			Cars instance = entityManager.find(Cars.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
