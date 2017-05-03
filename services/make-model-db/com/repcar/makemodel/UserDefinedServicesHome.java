package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class UserDefinedServices.
 * @see com.repcar.makemodel.UserDefinedServices
 * @author Hibernate Tools
 */
@Stateless
public class UserDefinedServicesHome {

	private static final Log log = LogFactory.getLog(UserDefinedServicesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UserDefinedServices transientInstance) {
		log.debug("persisting UserDefinedServices instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserDefinedServices persistentInstance) {
		log.debug("removing UserDefinedServices instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserDefinedServices merge(UserDefinedServices detachedInstance) {
		log.debug("merging UserDefinedServices instance");
		try {
			UserDefinedServices result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserDefinedServices findById(Integer id) {
		log.debug("getting UserDefinedServices instance with id: " + id);
		try {
			UserDefinedServices instance = entityManager.find(UserDefinedServices.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
