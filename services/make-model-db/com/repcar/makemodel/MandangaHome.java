package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Mandanga.
 * @see com.repcar.makemodel.Mandanga
 * @author Hibernate Tools
 */
@Stateless
public class MandangaHome {

	private static final Log log = LogFactory.getLog(MandangaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Mandanga transientInstance) {
		log.debug("persisting Mandanga instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Mandanga persistentInstance) {
		log.debug("removing Mandanga instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Mandanga merge(Mandanga detachedInstance) {
		log.debug("merging Mandanga instance");
		try {
			Mandanga result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Mandanga findById(Long id) {
		log.debug("getting Mandanga instance with id: " + id);
		try {
			Mandanga instance = entityManager.find(Mandanga.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
