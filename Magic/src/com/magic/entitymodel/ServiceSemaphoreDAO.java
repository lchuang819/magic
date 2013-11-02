package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for ServiceSemaphore entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ServiceSemaphore
  * @author MyEclipse Persistence Tools 
 */

public class ServiceSemaphoreDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ServiceSemaphoreDAO.class);
	//property constants
	public static final String LOCK_THREAD = "lockThread";



    
    public void save(ServiceSemaphore transientInstance) {
        log.debug("saving ServiceSemaphore instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ServiceSemaphore persistentInstance) {
        log.debug("deleting ServiceSemaphore instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ServiceSemaphore findById( java.lang.String id) {
        log.debug("getting ServiceSemaphore instance with id: " + id);
        try {
            ServiceSemaphore instance = (ServiceSemaphore) getSession()
                    .get("com.magic.entitymodel.ServiceSemaphore", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ServiceSemaphore instance) {
        log.debug("finding ServiceSemaphore instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ServiceSemaphore")
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
      log.debug("finding ServiceSemaphore instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ServiceSemaphore as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByLockThread(Object lockThread
	) {
		return findByProperty(LOCK_THREAD, lockThread
		);
	}
	

	public List findAll() {
		log.debug("finding all ServiceSemaphore instances");
		try {
			String queryString = "from ServiceSemaphore";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ServiceSemaphore merge(ServiceSemaphore detachedInstance) {
        log.debug("merging ServiceSemaphore instance");
        try {
            ServiceSemaphore result = (ServiceSemaphore) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ServiceSemaphore instance) {
        log.debug("attaching dirty ServiceSemaphore instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ServiceSemaphore instance) {
        log.debug("attaching clean ServiceSemaphore instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}