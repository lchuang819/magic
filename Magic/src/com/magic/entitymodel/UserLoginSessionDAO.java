package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserLoginSession entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserLoginSession
  * @author MyEclipse Persistence Tools 
 */

public class UserLoginSessionDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserLoginSessionDAO.class);
	//property constants
	public static final String SESSION_DATA = "sessionData";



    
    public void save(UserLoginSession transientInstance) {
        log.debug("saving UserLoginSession instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserLoginSession persistentInstance) {
        log.debug("deleting UserLoginSession instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserLoginSession findById( java.lang.String id) {
        log.debug("getting UserLoginSession instance with id: " + id);
        try {
            UserLoginSession instance = (UserLoginSession) getSession()
                    .get("com.magic.entitymodel.UserLoginSession", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserLoginSession instance) {
        log.debug("finding UserLoginSession instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserLoginSession")
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
      log.debug("finding UserLoginSession instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserLoginSession as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySessionData(Object sessionData
	) {
		return findByProperty(SESSION_DATA, sessionData
		);
	}
	

	public List findAll() {
		log.debug("finding all UserLoginSession instances");
		try {
			String queryString = "from UserLoginSession";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserLoginSession merge(UserLoginSession detachedInstance) {
        log.debug("merging UserLoginSession instance");
        try {
            UserLoginSession result = (UserLoginSession) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserLoginSession instance) {
        log.debug("attaching dirty UserLoginSession instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserLoginSession instance) {
        log.debug("attaching clean UserLoginSession instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}