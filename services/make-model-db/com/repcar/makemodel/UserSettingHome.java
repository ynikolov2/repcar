package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class UserSetting.
 * @see com.repcar.makemodel.UserSetting
 * @author Hibernate Tools
 */
@Stateless
public class UserSettingHome {

	private static final Log log = LogFactory.getLog(UserSettingHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(UserSetting transientInstance) {
		log.debug("persisting UserSetting instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(UserSetting persistentInstance) {
		log.debug("removing UserSetting instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public UserSetting merge(UserSetting detachedInstance) {
		log.debug("merging UserSetting instance");
		try {
			UserSetting result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserSetting findById(Integer id) {
		log.debug("getting UserSetting instance with id: " + id);
		try {
			UserSetting instance = entityManager.find(UserSetting.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
