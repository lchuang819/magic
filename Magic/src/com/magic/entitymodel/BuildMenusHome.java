package com.magic.entitymodel;

// Generated 2011-6-16 23:59:51 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class BuildMenus.
 * @see com.magic.entitymodel.BuildMenus
 * @author Hibernate Tools
 */
public class BuildMenusHome {

	private static final Log log = LogFactory.getLog(BuildMenusHome.class);

	private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void persist(BuildMenus transientInstance) {
		log.debug("persisting BuildMenus instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BuildMenus instance) {
		log.debug("attaching dirty BuildMenus instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BuildMenus instance) {
		log.debug("attaching clean BuildMenus instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BuildMenus persistentInstance) {
		log.debug("deleting BuildMenus instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BuildMenus merge(BuildMenus detachedInstance) {
		log.debug("merging BuildMenus instance");
		try {
			BuildMenus result = (BuildMenus) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BuildMenus findById(java.lang.String id) {
		log.debug("getting BuildMenus instance with id: " + id);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			BuildMenus instance = (BuildMenus) sessionFactory
					.getCurrentSession().get(
							"com.magic.entitymodel.BuildMenus", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<BuildMenus> findByExample(BuildMenus instance) {
		log.debug("finding BuildMenus instance by example");
		try {
			List<BuildMenus> results = (List<BuildMenus>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.magic.entitymodel.BuildMenus")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
