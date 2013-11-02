package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for BrowserType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.BrowserType
  * @author MyEclipse Persistence Tools 
 */

public class BrowserTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(BrowserTypeDAO.class);
	//property constants
	public static final String BROWSER_NAME = "browserName";
	public static final String BROWSER_VERSION = "browserVersion";



    
    public void save(BrowserType transientInstance) {
        log.debug("saving BrowserType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BrowserType persistentInstance) {
        log.debug("deleting BrowserType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BrowserType findById( java.lang.String id) {
        log.debug("getting BrowserType instance with id: " + id);
        try {
            BrowserType instance = (BrowserType) getSession()
                    .get("com.magic.entitymodel.BrowserType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BrowserType instance) {
        log.debug("finding BrowserType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.BrowserType")
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
      log.debug("finding BrowserType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BrowserType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByBrowserName(Object browserName
	) {
		return findByProperty(BROWSER_NAME, browserName
		);
	}
	
	public List findByBrowserVersion(Object browserVersion
	) {
		return findByProperty(BROWSER_VERSION, browserVersion
		);
	}
	

	public List findAll() {
		log.debug("finding all BrowserType instances");
		try {
			String queryString = "from BrowserType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public BrowserType merge(BrowserType detachedInstance) {
        log.debug("merging BrowserType instance");
        try {
            BrowserType result = (BrowserType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BrowserType instance) {
        log.debug("attaching dirty BrowserType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BrowserType instance) {
        log.debug("attaching clean BrowserType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}