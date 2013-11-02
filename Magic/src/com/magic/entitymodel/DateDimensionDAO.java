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
 	* A data access object (DAO) providing persistence and search support for DateDimension entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.DateDimension
  * @author MyEclipse Persistence Tools 
 */

public class DateDimensionDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(DateDimensionDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";
	public static final String DAY_NAME = "dayName";
	public static final String MONTH_NAME = "monthName";
	public static final String YEAR_MONTH_DAY = "yearMonthDay";
	public static final String YEAR_AND_MONTH = "yearAndMonth";
	public static final String WEEKDAY_TYPE = "weekdayType";



    
    public void save(DateDimension transientInstance) {
        log.debug("saving DateDimension instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(DateDimension persistentInstance) {
        log.debug("deleting DateDimension instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public DateDimension findById( java.lang.String id) {
        log.debug("getting DateDimension instance with id: " + id);
        try {
            DateDimension instance = (DateDimension) getSession()
                    .get("com.magic.entitymodel.DateDimension", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(DateDimension instance) {
        log.debug("finding DateDimension instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.DateDimension")
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
      log.debug("finding DateDimension instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from DateDimension as model where model." 
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
	
	public List findByDayName(Object dayName
	) {
		return findByProperty(DAY_NAME, dayName
		);
	}
	
	public List findByMonthName(Object monthName
	) {
		return findByProperty(MONTH_NAME, monthName
		);
	}
	
	public List findByYearMonthDay(Object yearMonthDay
	) {
		return findByProperty(YEAR_MONTH_DAY, yearMonthDay
		);
	}
	
	public List findByYearAndMonth(Object yearAndMonth
	) {
		return findByProperty(YEAR_AND_MONTH, yearAndMonth
		);
	}
	
	public List findByWeekdayType(Object weekdayType
	) {
		return findByProperty(WEEKDAY_TYPE, weekdayType
		);
	}
	

	public List findAll() {
		log.debug("finding all DateDimension instances");
		try {
			String queryString = "from DateDimension";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public DateDimension merge(DateDimension detachedInstance) {
        log.debug("merging DateDimension instance");
        try {
            DateDimension result = (DateDimension) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(DateDimension instance) {
        log.debug("attaching dirty DateDimension instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(DateDimension instance) {
        log.debug("attaching clean DateDimension instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}