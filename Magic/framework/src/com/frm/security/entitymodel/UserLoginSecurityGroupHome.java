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
 * Home object for domain model class UserLoginSecurityGroup.
 * @see com.frm.security.entitymodel.UserLoginSecurityGroup
 * @author Hibernate Tools
 */
public class UserLoginSecurityGroupHome {

	private static final Log log = LogFactory
			.getLog(UserLoginSecurityGroupHome.class);

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

	public void persist(UserLoginSecurityGroup transientInstance) {
		log.debug("persisting UserLoginSecurityGroup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserLoginSecurityGroup instance) {
		log.debug("attaching dirty UserLoginSecurityGroup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserLoginSecurityGroup instance) {
		log.debug("attaching clean UserLoginSecurityGroup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserLoginSecurityGroup persistentInstance) {
		log.debug("deleting UserLoginSecurityGroup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserLoginSecurityGroup merge(UserLoginSecurityGroup detachedInstance) {
		log.debug("merging UserLoginSecurityGroup instance");
		try {
			UserLoginSecurityGroup result = (UserLoginSecurityGroup) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserLoginSecurityGroup findById(
			com.frm.security.entitymodel.UserLoginSecurityGroupId id) {
		log.debug("getting UserLoginSecurityGroup instance with id: " + id);
		try {
			UserLoginSecurityGroup instance = (UserLoginSecurityGroup) sessionFactory
					.getCurrentSession().get(
							"com.magic.entitymodel.UserLoginSecurityGroup", id);
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

	public List<UserLoginSecurityGroup> findByExample(
			UserLoginSecurityGroup instance) {
		log.debug("finding UserLoginSecurityGroup instance by example");
		try {
			List<UserLoginSecurityGroup> results = (List<UserLoginSecurityGroup>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.magic.entitymodel.UserLoginSecurityGroup")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findByAnd(String criteria, Object instance){
		try {
			List results = (List) sessionFactory.getCurrentSession().createCriteria(criteria).add(create(instance).enableLike()).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by and failed", re);
			throw re;
		}
	}
}
