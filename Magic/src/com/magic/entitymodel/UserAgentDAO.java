package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UserAgent entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserAgent
  * @author MyEclipse Persistence Tools 
 */

public class UserAgentDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserAgentDAO.class);
	//property constants
	public static final String BROWSER_TYPE_ID = "browserTypeId";
	public static final String PLATFORM_TYPE_ID = "platformTypeId";
	public static final String PROTOCOL_TYPE_ID = "protocolTypeId";
	public static final String USER_AGENT_TYPE_ID = "userAgentTypeId";
	public static final String USER_AGENT_METHOD_TYPE_ID = "userAgentMethodTypeId";



    
    public void save(UserAgent transientInstance) {
        log.debug("saving UserAgent instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserAgent persistentInstance) {
        log.debug("deleting UserAgent instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserAgent findById( java.lang.String id) {
        log.debug("getting UserAgent instance with id: " + id);
        try {
            UserAgent instance = (UserAgent) getSession()
                    .get("com.magic.entitymodel.UserAgent", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserAgent instance) {
        log.debug("finding UserAgent instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserAgent")
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
      log.debug("finding UserAgent instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserAgent as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByBrowserTypeId(Object browserTypeId
	) {
		return findByProperty(BROWSER_TYPE_ID, browserTypeId
		);
	}
	
	public List findByPlatformTypeId(Object platformTypeId
	) {
		return findByProperty(PLATFORM_TYPE_ID, platformTypeId
		);
	}
	
	public List findByProtocolTypeId(Object protocolTypeId
	) {
		return findByProperty(PROTOCOL_TYPE_ID, protocolTypeId
		);
	}
	
	public List findByUserAgentTypeId(Object userAgentTypeId
	) {
		return findByProperty(USER_AGENT_TYPE_ID, userAgentTypeId
		);
	}
	
	public List findByUserAgentMethodTypeId(Object userAgentMethodTypeId
	) {
		return findByProperty(USER_AGENT_METHOD_TYPE_ID, userAgentMethodTypeId
		);
	}
	

	public List findAll() {
		log.debug("finding all UserAgent instances");
		try {
			String queryString = "from UserAgent";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserAgent merge(UserAgent detachedInstance) {
        log.debug("merging UserAgent instance");
        try {
            UserAgent result = (UserAgent) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserAgent instance) {
        log.debug("attaching dirty UserAgent instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserAgent instance) {
        log.debug("attaching clean UserAgent instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}