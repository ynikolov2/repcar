package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class WorkshopClients.
 * @see com.repcar.makemodel.WorkshopClients
 * @author Hibernate Tools
 */
@Stateless
public class WorkshopClientsHome {

	private static final Log log = LogFactory.getLog(WorkshopClientsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(WorkshopClients transientInstance) {
		log.debug("persisting WorkshopClients instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(WorkshopClients persistentInstance) {
		log.debug("removing WorkshopClients instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public WorkshopClients merge(WorkshopClients detachedInstance) {
		log.debug("merging WorkshopClients instance");
		try {
			WorkshopClients result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkshopClients findById(Integer id) {
		log.debug("getting WorkshopClients instance with id: " + id);
		try {
			WorkshopClients instance = entityManager.find(WorkshopClients.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
