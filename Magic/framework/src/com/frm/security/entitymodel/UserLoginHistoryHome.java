package com.frm.security.entitymodel;

// Generated 2011-6-16 23:59:51 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class UserLoginHistory.
 * @see com.frm.security.entitymodel.UserLoginHistory
 * @author Hibernate Tools
 */
public class UserLoginHistoryHome {

	private static final Log log = LogFactory
			.getLog(UserLoginHistoryHome.class);

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

	public void persist(UserLoginHistory transientInstance) {
		log.debug("persisting UserLoginHistory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserLoginHistory instance) {
		log.debug("attaching dirty UserLoginHistory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserLoginHistory instance) {
		log.debug("attaching clean UserLoginHistory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserLoginHistory persistentInstance) {
		log.debug("deleting UserLoginHistory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserLoginHistory merge(UserLoginHistory detachedInstance) {
		log.debug("merging UserLoginHistory instance");
		try {
			UserLoginHistory result = (UserLoginHistory) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserLoginHistory findById(com.frm.security.entitymodel.UserLoginHistoryId id) {
		log.debug("getting UserLoginHistory instance with id: " + id);
		try {
			UserLoginHistory instance = (UserLoginHistory) sessionFactory
					.getCurrentSession().get(
							"com.magic.entitymodel.UserLoginHistory", id);
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

	public List<UserLoginHistory> findByExample(UserLoginHistory instance) {
		log.debug("finding UserLoginHistory instance by example");
		try {
			List<UserLoginHistory> results = (List<UserLoginHistory>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.magic.entitymodel.UserLoginHistory")
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
