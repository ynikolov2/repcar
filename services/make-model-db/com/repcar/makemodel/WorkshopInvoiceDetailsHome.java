package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class WorkshopInvoiceDetails.
 * @see com.repcar.makemodel.WorkshopInvoiceDetails
 * @author Hibernate Tools
 */
@Stateless
public class WorkshopInvoiceDetailsHome {

	private static final Log log = LogFactory.getLog(WorkshopInvoiceDetailsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(WorkshopInvoiceDetails transientInstance) {
		log.debug("persisting WorkshopInvoiceDetails instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(WorkshopInvoiceDetails persistentInstance) {
		log.debug("removing WorkshopInvoiceDetails instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public WorkshopInvoiceDetails merge(WorkshopInvoiceDetails detachedInstance) {
		log.debug("merging WorkshopInvoiceDetails instance");
		try {
			WorkshopInvoiceDetails result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public WorkshopInvoiceDetails findById(Integer id) {
		log.debug("getting WorkshopInvoiceDetails instance with id: " + id);
		try {
			WorkshopInvoiceDetails instance = entityManager.find(WorkshopInvoiceDetails.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
