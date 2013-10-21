package com.frm.security.entitymodel;

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
 * Home object for domain model class UserLogin.
 * @see com.frm.security.entitymodel.UserLogin
 * @author Hibernate Tools
 */
public class UserLoginHome {

	private static final Log log = LogFactory.getLog(UserLoginHome.class);

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

	public void persist(UserLogin transientInstance) {
		log.debug("persisting UserLogin instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserLogin instance) {
		log.debug("attaching dirty UserLogin instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserLogin instance) {
		log.debug("attaching clean UserLogin instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserLogin persistentInstance) {
		log.debug("deleting UserLogin instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserLogin merge(UserLogin detachedInstance) {
		log.debug("merging UserLogin instance");
		try {
			UserLogin result = (UserLogin) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserLogin findById(java.lang.String id) {
		log.debug("getting UserLogin instance with id: " + id);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			UserLogin instance = (UserLogin) sessionFactory.getCurrentSession()
					.get("com.magic.entitymodel.UserLogin", id);
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

	public List<UserLogin> findByExample(UserLogin instance) {
		log.debug("finding UserLogin instance by example");
		try {
			List<UserLogin> results = (List<UserLogin>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.magic.entitymodel.UserLogin")
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
