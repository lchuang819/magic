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
 * Home object for domain model class BuildUserMenus.
 * @see com.magic.entitymodel.BuildUserMenus
 * @author Hibernate Tools
 */
public class BuildUserMenusHome {

	private static final Log log = LogFactory.getLog(BuildUserMenusHome.class);

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

	public void persist(BuildUserMenus transientInstance) {
		log.debug("persisting BuildUserMenus instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(BuildUserMenus instance) {
		log.debug("attaching dirty BuildUserMenus instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BuildUserMenus instance) {
		log.debug("attaching clean BuildUserMenus instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(BuildUserMenus persistentInstance) {
		log.debug("deleting BuildUserMenus instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BuildUserMenus merge(BuildUserMenus detachedInstance) {
		log.debug("merging BuildUserMenus instance");
		try {
			BuildUserMenus result = (BuildUserMenus) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public BuildUserMenus findById(com.magic.entitymodel.BuildUserMenusId id) {
		log.debug("getting BuildUserMenus instance with id: " + id);
		try {
			BuildUserMenus instance = (BuildUserMenus) sessionFactory
					.getCurrentSession().get(
							"com.magic.entitymodel.BuildUserMenus", id);
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

	public List<BuildUserMenus> findByExample(BuildUserMenus instance) {
		log.debug("finding BuildUserMenus instance by example");
		try {
			List<BuildUserMenus> results = (List<BuildUserMenus>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.magic.entitymodel.BuildUserMenus")
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
