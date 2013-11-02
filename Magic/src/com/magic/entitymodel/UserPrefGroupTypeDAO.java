package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserPrefGroupType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserPrefGroupType
  * @author MyEclipse Persistence Tools 
 */

public class UserPrefGroupTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserPrefGroupTypeDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";



    
    public void save(UserPrefGroupType transientInstance) {
        log.debug("saving UserPrefGroupType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserPrefGroupType persistentInstance) {
        log.debug("deleting UserPrefGroupType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserPrefGroupType findById( java.lang.String id) {
        log.debug("getting UserPrefGroupType instance with id: " + id);
        try {
            UserPrefGroupType instance = (UserPrefGroupType) getSession()
                    .get("com.magic.entitymodel.UserPrefGroupType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserPrefGroupType instance) {
        log.debug("finding UserPrefGroupType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserPrefGroupType")
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
      log.debug("finding UserPrefGroupType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserPrefGroupType as model where model." 
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
		log.debug("finding all UserPrefGroupType instances");
		try {
			String queryString = "from UserPrefGroupType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserPrefGroupType merge(UserPrefGroupType detachedInstance) {
        log.debug("merging UserPrefGroupType instance");
        try {
            UserPrefGroupType result = (UserPrefGroupType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserPrefGroupType instance) {
        log.debug("attaching dirty UserPrefGroupType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserPrefGroupType instance) {
        log.debug("attaching clean UserPrefGroupType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}