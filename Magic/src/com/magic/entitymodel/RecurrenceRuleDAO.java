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
 	* A data access object (DAO) providing persistence and search support for RecurrenceRule entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.RecurrenceRule
  * @author MyEclipse Persistence Tools 
 */

public class RecurrenceRuleDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(RecurrenceRuleDAO.class);
	//property constants
	public static final String FREQUENCY = "frequency";
	public static final String BY_SECOND_LIST = "bySecondList";
	public static final String BY_MINUTE_LIST = "byMinuteList";
	public static final String BY_HOUR_LIST = "byHourList";
	public static final String BY_DAY_LIST = "byDayList";
	public static final String BY_MONTH_DAY_LIST = "byMonthDayList";
	public static final String BY_YEAR_DAY_LIST = "byYearDayList";
	public static final String BY_WEEK_NO_LIST = "byWeekNoList";
	public static final String BY_MONTH_LIST = "byMonthList";
	public static final String BY_SET_POS_LIST = "bySetPosList";
	public static final String WEEK_START = "weekStart";
	public static final String _XNAME = "XName";



    
    public void save(RecurrenceRule transientInstance) {
        log.debug("saving RecurrenceRule instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RecurrenceRule persistentInstance) {
        log.debug("deleting RecurrenceRule instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RecurrenceRule findById( java.lang.String id) {
        log.debug("getting RecurrenceRule instance with id: " + id);
        try {
            RecurrenceRule instance = (RecurrenceRule) getSession()
                    .get("com.magic.entitymodel.RecurrenceRule", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(RecurrenceRule instance) {
        log.debug("finding RecurrenceRule instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.RecurrenceRule")
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
      log.debug("finding RecurrenceRule instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RecurrenceRule as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFrequency(Object frequency
	) {
		return findByProperty(FREQUENCY, frequency
		);
	}
	
	public List findByBySecondList(Object bySecondList
	) {
		return findByProperty(BY_SECOND_LIST, bySecondList
		);
	}
	
	public List findByByMinuteList(Object byMinuteList
	) {
		return findByProperty(BY_MINUTE_LIST, byMinuteList
		);
	}
	
	public List findByByHourList(Object byHourList
	) {
		return findByProperty(BY_HOUR_LIST, byHourList
		);
	}
	
	public List findByByDayList(Object byDayList
	) {
		return findByProperty(BY_DAY_LIST, byDayList
		);
	}
	
	public List findByByMonthDayList(Object byMonthDayList
	) {
		return findByProperty(BY_MONTH_DAY_LIST, byMonthDayList
		);
	}
	
	public List findByByYearDayList(Object byYearDayList
	) {
		return findByProperty(BY_YEAR_DAY_LIST, byYearDayList
		);
	}
	
	public List findByByWeekNoList(Object byWeekNoList
	) {
		return findByProperty(BY_WEEK_NO_LIST, byWeekNoList
		);
	}
	
	public List findByByMonthList(Object byMonthList
	) {
		return findByProperty(BY_MONTH_LIST, byMonthList
		);
	}
	
	public List findByBySetPosList(Object bySetPosList
	) {
		return findByProperty(BY_SET_POS_LIST, bySetPosList
		);
	}
	
	public List findByWeekStart(Object weekStart
	) {
		return findByProperty(WEEK_START, weekStart
		);
	}
	
	public List findByXName(Object XName
	) {
		return findByProperty(_XNAME, XName
		);
	}
	

	public List findAll() {
		log.debug("finding all RecurrenceRule instances");
		try {
			String queryString = "from RecurrenceRule";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RecurrenceRule merge(RecurrenceRule detachedInstance) {
        log.debug("merging RecurrenceRule instance");
        try {
            RecurrenceRule result = (RecurrenceRule) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RecurrenceRule instance) {
        log.debug("attaching dirty RecurrenceRule instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RecurrenceRule instance) {
        log.debug("attaching clean RecurrenceRule instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}