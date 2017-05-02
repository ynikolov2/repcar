package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Vehicles.
 * @see com.repcar.makemodel.Vehicles
 * @author Hibernate Tools
 */
@Stateless
public class VehiclesHome {

	private static final Log log = LogFactory.getLog(VehiclesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Vehicles transientInstance) {
		log.debug("persisting Vehicles instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Vehicles persistentInstance) {
		log.debug("removing Vehicles instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Vehicles merge(Vehicles detachedInstance) {
		log.debug("merging Vehicles instance");
		try {
			Vehicles result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vehicles findById(Integer id) {
		log.debug("getting Vehicles instance with id: " + id);
		try {
			Vehicles instance = entityManager.find(Vehicles.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
