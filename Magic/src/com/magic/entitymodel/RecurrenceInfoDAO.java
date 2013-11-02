package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for RecurrenceInfo entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.RecurrenceInfo
  * @author MyEclipse Persistence Tools 
 */

public class RecurrenceInfoDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(RecurrenceInfoDAO.class);
	//property constants
	public static final String EXCEPTION_DATE_TIMES = "exceptionDateTimes";
	public static final String RECURRENCE_DATE_TIMES = "recurrenceDateTimes";
	public static final String EXCEPTION_RULE_ID = "exceptionRuleId";
	public static final String RECURRENCE_RULE_ID = "recurrenceRuleId";



    
    public void save(RecurrenceInfo transientInstance) {
        log.debug("saving RecurrenceInfo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RecurrenceInfo persistentInstance) {
        log.debug("deleting RecurrenceInfo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RecurrenceInfo findById( java.lang.String id) {
        log.debug("getting RecurrenceInfo instance with id: " + id);
        try {
            RecurrenceInfo instance = (RecurrenceInfo) getSession()
                    .get("com.magic.entitymodel.RecurrenceInfo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RecurrenceInfo instance) {
        log.debug("finding RecurrenceInfo instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.RecurrenceInfo")
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
      log.debug("finding RecurrenceInfo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RecurrenceInfo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByExceptionDateTimes(Object exceptionDateTimes
	) {
		return findByProperty(EXCEPTION_DATE_TIMES, exceptionDateTimes
		);
	}
	
	public List findByRecurrenceDateTimes(Object recurrenceDateTimes
	) {
		return findByProperty(RECURRENCE_DATE_TIMES, recurrenceDateTimes
		);
	}
	
	public List findByExceptionRuleId(Object exceptionRuleId
	) {
		return findByProperty(EXCEPTION_RULE_ID, exceptionRuleId
		);
	}
	
	public List findByRecurrenceRuleId(Object recurrenceRuleId
	) {
		return findByProperty(RECURRENCE_RULE_ID, recurrenceRuleId
		);
	}
	

	public List findAll() {
		log.debug("finding all RecurrenceInfo instances");
		try {
			String queryString = "from RecurrenceInfo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RecurrenceInfo merge(RecurrenceInfo detachedInstance) {
        log.debug("merging RecurrenceInfo instance");
        try {
            RecurrenceInfo result = (RecurrenceInfo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RecurrenceInfo instance) {
        log.debug("attaching dirty RecurrenceInfo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RecurrenceInfo instance) {
        log.debug("attaching clean RecurrenceInfo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}