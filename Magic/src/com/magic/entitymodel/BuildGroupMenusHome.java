package com.magic.entitymodel;

// Generated 2011-6-16 23:59:51 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class BuildGroupMenus.
 * @see com.magic.entitymodel.BuildGroupMenus
 * @author Hibernate Tools
 */
public class BuildGroupMenusHome {

	private static final Log log = LogFactory.getLog(BuildGroupMenusHome.class);

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

	public void persist(BuildGroupMenus transientInstance) {
		log.debug("persisting BuildGroupMenus instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BuildGroupMenus instance) {
		log.debug("attaching dirty BuildGroupMenus instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BuildGroupMenus instance) {
		log.debug("attaching clean BuildGroupMenus instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BuildGroupMenus persistentInstance) {
		log.debug("deleting BuildGroupMenus instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BuildGroupMenus merge(BuildGroupMenus detachedInstance) {
		log.debug("merging BuildGroupMenus instance");
		try {
			BuildGroupMenus result = (BuildGroupMenus) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BuildGroupMenus findById(com.magic.entitymodel.BuildGroupMenusId id) {
		log.debug("getting BuildGroupMenus instance with id: " + id);
		try {
			BuildGroupMenus instance = (BuildGroupMenus) sessionFactory
					.getCurrentSession().get(
							"com.magic.entitymodel.BuildGroupMenus", id);
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

	public List<BuildGroupMenus> findByExample(BuildGroupMenus instance) {
		log.debug("finding BuildGroupMenus instance by example");
		try {
			List<BuildGroupMenus> results = (List<BuildGroupMenus>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.magic.entitymodel.BuildGroupMenus")
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
