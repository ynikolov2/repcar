package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Company.
 * @see com.repcar.makemodel.Company
 * @author Hibernate Tools
 */
@Stateless
public class CompanyHome {

	private static final Log log = LogFactory.getLog(CompanyHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Company transientInstance) {
		log.debug("persisting Company instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Company persistentInstance) {
		log.debug("removing Company instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Company merge(Company detachedInstance) {
		log.debug("merging Company instance");
		try {
			Company result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Company findById(Integer id) {
		log.debug("getting Company instance with id: " + id);
		try {
			Company instance = entityManager.find(Company.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
