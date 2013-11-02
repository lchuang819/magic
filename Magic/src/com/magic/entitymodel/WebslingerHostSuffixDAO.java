package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for WebslingerHostSuffix entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.WebslingerHostSuffix
  * @author MyEclipse Persistence Tools 
 */

public class WebslingerHostSuffixDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(WebslingerHostSuffixDAO.class);
	//property constants
	public static final String HOST_SUFFIX = "hostSuffix";



    
    public void save(WebslingerHostSuffix transientInstance) {
        log.debug("saving WebslingerHostSuffix instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WebslingerHostSuffix persistentInstance) {
        log.debug("deleting WebslingerHostSuffix instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WebslingerHostSuffix findById( java.lang.String id) {
        log.debug("getting WebslingerHostSuffix instance with id: " + id);
        try {
            WebslingerHostSuffix instance = (WebslingerHostSuffix) getSession()
                    .get("com.magic.entitymodel.WebslingerHostSuffix", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WebslingerHostSuffix instance) {
        log.debug("finding WebslingerHostSuffix instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.WebslingerHostSuffix")
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
      log.debug("finding WebslingerHostSuffix instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WebslingerHostSuffix as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByHostSuffix(Object hostSuffix
	) {
		return findByProperty(HOST_SUFFIX, hostSuffix
		);
	}
	

	public List findAll() {
		log.debug("finding all WebslingerHostSuffix instances");
		try {
			String queryString = "from WebslingerHostSuffix";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WebslingerHostSuffix merge(WebslingerHostSuffix detachedInstance) {
        log.debug("merging WebslingerHostSuffix instance");
        try {
            WebslingerHostSuffix result = (WebslingerHostSuffix) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WebslingerHostSuffix instance) {
        log.debug("attaching dirty WebslingerHostSuffix instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WebslingerHostSuffix instance) {
        log.debug("attaching clean WebslingerHostSuffix instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}