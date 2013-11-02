package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for PlatformType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PlatformType
  * @author MyEclipse Persistence Tools 
 */

public class PlatformTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PlatformTypeDAO.class);
	//property constants
	public static final String PLATFORM_NAME = "platformName";
	public static final String PLATFORM_VERSION = "platformVersion";



    
    public void save(PlatformType transientInstance) {
        log.debug("saving PlatformType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PlatformType persistentInstance) {
        log.debug("deleting PlatformType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PlatformType findById( java.lang.String id) {
        log.debug("getting PlatformType instance with id: " + id);
        try {
            PlatformType instance = (PlatformType) getSession()
                    .get("com.magic.entitymodel.PlatformType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PlatformType instance) {
        log.debug("finding PlatformType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PlatformType")
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
      log.debug("finding PlatformType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PlatformType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPlatformName(Object platformName
	) {
		return findByProperty(PLATFORM_NAME, platformName
		);
	}
	
	public List findByPlatformVersion(Object platformVersion
	) {
		return findByProperty(PLATFORM_VERSION, platformVersion
		);
	}
	

	public List findAll() {
		log.debug("finding all PlatformType instances");
		try {
			String queryString = "from PlatformType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PlatformType merge(PlatformType detachedInstance) {
        log.debug("merging PlatformType instance");
        try {
            PlatformType result = (PlatformType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PlatformType instance) {
        log.debug("attaching dirty PlatformType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PlatformType instance) {
        log.debug("attaching clean PlatformType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}