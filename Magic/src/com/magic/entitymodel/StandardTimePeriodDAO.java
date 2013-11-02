package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for StandardTimePeriod entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.StandardTimePeriod
  * @author MyEclipse Persistence Tools 
 */

public class StandardTimePeriodDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(StandardTimePeriodDAO.class);
	//property constants
	public static final String PERIOD_TYPE_ID = "periodTypeId";



    
    public void save(StandardTimePeriod transientInstance) {
        log.debug("saving StandardTimePeriod instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(StandardTimePeriod persistentInstance) {
        log.debug("deleting StandardTimePeriod instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public StandardTimePeriod findById( java.lang.String id) {
        log.debug("getting StandardTimePeriod instance with id: " + id);
        try {
            StandardTimePeriod instance = (StandardTimePeriod) getSession()
                    .get("com.magic.entitymodel.StandardTimePeriod", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(StandardTimePeriod instance) {
        log.debug("finding StandardTimePeriod instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.StandardTimePeriod")
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
      log.debug("finding StandardTimePeriod instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StandardTimePeriod as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPeriodTypeId(Object periodTypeId
	) {
		return findByProperty(PERIOD_TYPE_ID, periodTypeId
		);
	}
	

	public List findAll() {
		log.debug("finding all StandardTimePeriod instances");
		try {
			String queryString = "from StandardTimePeriod";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public StandardTimePeriod merge(StandardTimePeriod detachedInstance) {
        log.debug("merging StandardTimePeriod instance");
        try {
            StandardTimePeriod result = (StandardTimePeriod) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(StandardTimePeriod instance) {
        log.debug("attaching dirty StandardTimePeriod instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(StandardTimePeriod instance) {
        log.debug("attaching clean StandardTimePeriod instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}