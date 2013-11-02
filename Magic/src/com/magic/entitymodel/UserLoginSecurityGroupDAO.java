package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserLoginSecurityGroup entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserLoginSecurityGroup
  * @author MyEclipse Persistence Tools 
 */

public class UserLoginSecurityGroupDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserLoginSecurityGroupDAO.class);
	//property constants



    
    public void save(UserLoginSecurityGroup transientInstance) {
        log.debug("saving UserLoginSecurityGroup instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserLoginSecurityGroup persistentInstance) {
        log.debug("deleting UserLoginSecurityGroup instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserLoginSecurityGroup findById( com.magic.entitymodel.UserLoginSecurityGroupId id) {
        log.debug("getting UserLoginSecurityGroup instance with id: " + id);
        try {
            UserLoginSecurityGroup instance = (UserLoginSecurityGroup) getSession()
                    .get("com.magic.entitymodel.UserLoginSecurityGroup", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserLoginSecurityGroup instance) {
        log.debug("finding UserLoginSecurityGroup instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserLoginSecurityGroup")
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
      log.debug("finding UserLoginSecurityGroup instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserLoginSecurityGroup as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all UserLoginSecurityGroup instances");
		try {
			String queryString = "from UserLoginSecurityGroup";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserLoginSecurityGroup merge(UserLoginSecurityGroup detachedInstance) {
        log.debug("merging UserLoginSecurityGroup instance");
        try {
            UserLoginSecurityGroup result = (UserLoginSecurityGroup) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserLoginSecurityGroup instance) {
        log.debug("attaching dirty UserLoginSecurityGroup instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserLoginSecurityGroup instance) {
        log.debug("attaching clean UserLoginSecurityGroup instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}