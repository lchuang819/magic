package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserLoginHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserLoginHistory
  * @author MyEclipse Persistence Tools 
 */

public class UserLoginHistoryDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserLoginHistoryDAO.class);
	//property constants
	public static final String VISIT_ID = "visitId";
	public static final String PASSWORD_USED = "passwordUsed";
	public static final String SUCCESSFUL_LOGIN = "successfulLogin";



    
    public void save(UserLoginHistory transientInstance) {
        log.debug("saving UserLoginHistory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserLoginHistory persistentInstance) {
        log.debug("deleting UserLoginHistory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserLoginHistory findById( com.magic.entitymodel.UserLoginHistoryId id) {
        log.debug("getting UserLoginHistory instance with id: " + id);
        try {
            UserLoginHistory instance = (UserLoginHistory) getSession()
                    .get("com.magic.entitymodel.UserLoginHistory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserLoginHistory instance) {
        log.debug("finding UserLoginHistory instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserLoginHistory")
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
      log.debug("finding UserLoginHistory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserLoginHistory as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByVisitId(Object visitId
	) {
		return findByProperty(VISIT_ID, visitId
		);
	}
	
	public List findByPasswordUsed(Object passwordUsed
	) {
		return findByProperty(PASSWORD_USED, passwordUsed
		);
	}
	
	public List findBySuccessfulLogin(Object successfulLogin
	) {
		return findByProperty(SUCCESSFUL_LOGIN, successfulLogin
		);
	}
	

	public List findAll() {
		log.debug("finding all UserLoginHistory instances");
		try {
			String queryString = "from UserLoginHistory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserLoginHistory merge(UserLoginHistory detachedInstance) {
        log.debug("merging UserLoginHistory instance");
        try {
            UserLoginHistory result = (UserLoginHistory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserLoginHistory instance) {
        log.debug("attaching dirty UserLoginHistory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserLoginHistory instance) {
        log.debug("attaching clean UserLoginHistory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}