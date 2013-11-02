package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserLoginPasswordHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserLoginPasswordHistory
  * @author MyEclipse Persistence Tools 
 */

public class UserLoginPasswordHistoryDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserLoginPasswordHistoryDAO.class);
	//property constants
	public static final String CURRENT_PASSWORD = "currentPassword";



    
    public void save(UserLoginPasswordHistory transientInstance) {
        log.debug("saving UserLoginPasswordHistory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserLoginPasswordHistory persistentInstance) {
        log.debug("deleting UserLoginPasswordHistory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserLoginPasswordHistory findById( com.magic.entitymodel.UserLoginPasswordHistoryId id) {
        log.debug("getting UserLoginPasswordHistory instance with id: " + id);
        try {
            UserLoginPasswordHistory instance = (UserLoginPasswordHistory) getSession()
                    .get("com.magic.entitymodel.UserLoginPasswordHistory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserLoginPasswordHistory instance) {
        log.debug("finding UserLoginPasswordHistory instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserLoginPasswordHistory")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserLoginPasswordHistory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserLoginPasswordHistory as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCurrentPassword(Object currentPassword
	) {
		return findByProperty(CURRENT_PASSWORD, currentPassword
		);
	}
	

	public List findAll() {
		log.debug("finding all UserLoginPasswordHistory instances");
		try {
			String queryString = "from UserLoginPasswordHistory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserLoginPasswordHistory merge(UserLoginPasswordHistory detachedInstance) {
        log.debug("merging UserLoginPasswordHistory instance");
        try {
            UserLoginPasswordHistory result = (UserLoginPasswordHistory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserLoginPasswordHistory instance) {
        log.debug("attaching dirty UserLoginPasswordHistory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserLoginPasswordHistory instance) {
        log.debug("attaching clean UserLoginPasswordHistory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}