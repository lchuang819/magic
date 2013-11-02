package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserPreference entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserPreference
  * @author MyEclipse Persistence Tools 
 */

public class UserPreferenceDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserPreferenceDAO.class);
	//property constants
	public static final String USER_PREF_GROUP_TYPE_ID = "userPrefGroupTypeId";
	public static final String USER_PREF_VALUE = "userPrefValue";
	public static final String USER_PREF_DATA_TYPE = "userPrefDataType";



    
    public void save(UserPreference transientInstance) {
        log.debug("saving UserPreference instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserPreference persistentInstance) {
        log.debug("deleting UserPreference instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserPreference findById( com.magic.entitymodel.UserPreferenceId id) {
        log.debug("getting UserPreference instance with id: " + id);
        try {
            UserPreference instance = (UserPreference) getSession()
                    .get("com.magic.entitymodel.UserPreference", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserPreference instance) {
        log.debug("finding UserPreference instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserPreference")
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
      log.debug("finding UserPreference instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserPreference as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUserPrefGroupTypeId(Object userPrefGroupTypeId
	) {
		return findByProperty(USER_PREF_GROUP_TYPE_ID, userPrefGroupTypeId
		);
	}
	
	public List findByUserPrefValue(Object userPrefValue
	) {
		return findByProperty(USER_PREF_VALUE, userPrefValue
		);
	}
	
	public List findByUserPrefDataType(Object userPrefDataType
	) {
		return findByProperty(USER_PREF_DATA_TYPE, userPrefDataType
		);
	}
	

	public List findAll() {
		log.debug("finding all UserPreference instances");
		try {
			String queryString = "from UserPreference";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserPreference merge(UserPreference detachedInstance) {
        log.debug("merging UserPreference instance");
        try {
            UserPreference result = (UserPreference) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserPreference instance) {
        log.debug("attaching dirty UserPreference instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserPreference instance) {
        log.debug("attaching clean UserPreference instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}