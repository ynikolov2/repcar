package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class OauthAccessToken.
 * @see com.repcar.makemodel.OauthAccessToken
 * @author Hibernate Tools
 */
@Stateless
public class OauthAccessTokenHome {

	private static final Log log = LogFactory.getLog(OauthAccessTokenHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(OauthAccessToken transientInstance) {
		log.debug("persisting OauthAccessToken instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(OauthAccessToken persistentInstance) {
		log.debug("removing OauthAccessToken instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public OauthAccessToken merge(OauthAccessToken detachedInstance) {
		log.debug("merging OauthAccessToken instance");
		try {
			OauthAccessToken result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OauthAccessToken findById(String id) {
		log.debug("getting OauthAccessToken instance with id: " + id);
		try {
			OauthAccessToken instance = entityManager.find(OauthAccessToken.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
