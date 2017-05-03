package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ServiceCategories.
 * @see com.repcar.makemodel.ServiceCategories
 * @author Hibernate Tools
 */
@Stateless
public class ServiceCategoriesHome {

	private static final Log log = LogFactory.getLog(ServiceCategoriesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ServiceCategories transientInstance) {
		log.debug("persisting ServiceCategories instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ServiceCategories persistentInstance) {
		log.debug("removing ServiceCategories instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ServiceCategories merge(ServiceCategories detachedInstance) {
		log.debug("merging ServiceCategories instance");
		try {
			ServiceCategories result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ServiceCategories findById(Integer id) {
		log.debug("getting ServiceCategories instance with id: " + id);
		try {
			ServiceCategories instance = entityManager.find(ServiceCategories.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
