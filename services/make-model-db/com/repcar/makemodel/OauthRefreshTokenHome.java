package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class OauthRefreshToken.
 * @see com.repcar.makemodel.OauthRefreshToken
 * @author Hibernate Tools
 */
@Stateless
public class OauthRefreshTokenHome {

	private static final Log log = LogFactory.getLog(OauthRefreshTokenHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(OauthRefreshToken transientInstance) {
		log.debug("persisting OauthRefreshToken instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(OauthRefreshToken persistentInstance) {
		log.debug("removing OauthRefreshToken instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OauthRefreshToken merge(OauthRefreshToken detachedInstance) {
		log.debug("merging OauthRefreshToken instance");
		try {
			OauthRefreshToken result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OauthRefreshToken findById(String id) {
		log.debug("getting OauthRefreshToken instance with id: " + id);
		try {
			OauthRefreshToken instance = entityManager.find(OauthRefreshToken.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
