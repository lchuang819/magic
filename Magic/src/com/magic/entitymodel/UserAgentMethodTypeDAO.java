package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserAgentMethodType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserAgentMethodType
  * @author MyEclipse Persistence Tools 
 */

public class UserAgentMethodTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserAgentMethodTypeDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";



    
    public void save(UserAgentMethodType transientInstance) {
        log.debug("saving UserAgentMethodType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserAgentMethodType persistentInstance) {
        log.debug("deleting UserAgentMethodType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserAgentMethodType findById( java.lang.String id) {
        log.debug("getting UserAgentMethodType instance with id: " + id);
        try {
            UserAgentMethodType instance = (UserAgentMethodType) getSession()
                    .get("com.magic.entitymodel.UserAgentMethodType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserAgentMethodType instance) {
        log.debug("finding UserAgentMethodType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserAgentMethodType")
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
      log.debug("finding UserAgentMethodType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserAgentMethodType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all UserAgentMethodType instances");
		try {
			String queryString = "from UserAgentMethodType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserAgentMethodType merge(UserAgentMethodType detachedInstance) {
        log.debug("merging UserAgentMethodType instance");
        try {
            UserAgentMethodType result = (UserAgentMethodType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserAgentMethodType instance) {
        log.debug("attaching dirty UserAgentMethodType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserAgentMethodType instance) {
        log.debug("attaching clean UserAgentMethodType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}