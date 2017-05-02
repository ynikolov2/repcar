package com.repcar.makemodel;
// Generated May 2, 2017 2:05:10 PM by Hibernate Tools 5.2.1.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ClientInvoiceDetails.
 * @see com.repcar.makemodel.ClientInvoiceDetails
 * @author Hibernate Tools
 */
@Stateless
public class ClientInvoiceDetailsHome {

	private static final Log log = LogFactory.getLog(ClientInvoiceDetailsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ClientInvoiceDetails transientInstance) {
		log.debug("persisting ClientInvoiceDetails instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ClientInvoiceDetails persistentInstance) {
		log.debug("removing ClientInvoiceDetails instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ClientInvoiceDetails merge(ClientInvoiceDetails detachedInstance) {
		log.debug("merging ClientInvoiceDetails instance");
		try {
			ClientInvoiceDetails result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ClientInvoiceDetails findById(int id) {
		log.debug("getting ClientInvoiceDetails instance with id: " + id);
		try {
			ClientInvoiceDetails instance = entityManager.find(ClientInvoiceDetails.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
