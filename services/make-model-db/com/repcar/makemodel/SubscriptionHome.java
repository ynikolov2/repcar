package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Subscription.
 * @see com.repcar.makemodel.Subscription
 * @author Hibernate Tools
 */
@Stateless
public class SubscriptionHome {

	private static final Log log = LogFactory.getLog(SubscriptionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Subscription transientInstance) {
		log.debug("persisting Subscription instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Subscription persistentInstance) {
		log.debug("removing Subscription instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Subscription merge(Subscription detachedInstance) {
		log.debug("merging Subscription instance");
		try {
			Subscription result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Subscription findById(Integer id) {
		log.debug("getting Subscription instance with id: " + id);
		try {
			Subscription instance = entityManager.find(Subscription.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
