package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for CustomTimePeriod entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.CustomTimePeriod
  * @author MyEclipse Persistence Tools 
 */

public class CustomTimePeriodDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(CustomTimePeriodDAO.class);
	//property constants
	public static final String PARENT_PERIOD_ID = "parentPeriodId";
	public static final String PERIOD_TYPE_ID = "periodTypeId";
	public static final String PERIOD_NAME = "periodName";
	public static final String IS_CLOSED = "isClosed";



    
    public void save(CustomTimePeriod transientInstance) {
        log.debug("saving CustomTimePeriod instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CustomTimePeriod persistentInstance) {
        log.debug("deleting CustomTimePeriod instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CustomTimePeriod findById( java.lang.String id) {
        log.debug("getting CustomTimePeriod instance with id: " + id);
        try {
            CustomTimePeriod instance = (CustomTimePeriod) getSession()
                    .get("com.magic.entitymodel.CustomTimePeriod", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CustomTimePeriod instance) {
        log.debug("finding CustomTimePeriod instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.CustomTimePeriod")
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
      log.debug("finding CustomTimePeriod instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CustomTimePeriod as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByParentPeriodId(Object parentPeriodId
	) {
		return findByProperty(PARENT_PERIOD_ID, parentPeriodId
		);
	}
	
	public List findByPeriodTypeId(Object periodTypeId
	) {
		return findByProperty(PERIOD_TYPE_ID, periodTypeId
		);
	}
	
	public List findByPeriodName(Object periodName
	) {
		return findByProperty(PERIOD_NAME, periodName
		);
	}
	
	public List findByIsClosed(Object isClosed
	) {
		return findByProperty(IS_CLOSED, isClosed
		);
	}
	

	public List findAll() {
		log.debug("finding all CustomTimePeriod instances");
		try {
			String queryString = "from CustomTimePeriod";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CustomTimePeriod merge(CustomTimePeriod detachedInstance) {
        log.debug("merging CustomTimePeriod instance");
        try {
            CustomTimePeriod result = (CustomTimePeriod) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CustomTimePeriod instance) {
        log.debug("attaching dirty CustomTimePeriod instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CustomTimePeriod instance) {
        log.debug("attaching clean CustomTimePeriod instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}