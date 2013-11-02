package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for CountryCode entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.CountryCode
  * @author MyEclipse Persistence Tools 
 */

public class CountryCodeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(CountryCodeDAO.class);
	//property constants
	public static final String COUNTRY_ABBR = "countryAbbr";
	public static final String COUNTRY_NUMBER = "countryNumber";
	public static final String COUNTRY_NAME = "countryName";



    
    public void save(CountryCode transientInstance) {
        log.debug("saving CountryCode instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CountryCode persistentInstance) {
        log.debug("deleting CountryCode instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CountryCode findById( java.lang.String id) {
        log.debug("getting CountryCode instance with id: " + id);
        try {
            CountryCode instance = (CountryCode) getSession()
                    .get("com.magic.entitymodel.CountryCode", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CountryCode instance) {
        log.debug("finding CountryCode instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.CountryCode")
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
      log.debug("finding CountryCode instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CountryCode as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCountryAbbr(Object countryAbbr
	) {
		return findByProperty(COUNTRY_ABBR, countryAbbr
		);
	}
	
	public List findByCountryNumber(Object countryNumber
	) {
		return findByProperty(COUNTRY_NUMBER, countryNumber
		);
	}
	
	public List findByCountryName(Object countryName
	) {
		return findByProperty(COUNTRY_NAME, countryName
		);
	}
	

	public List findAll() {
		log.debug("finding all CountryCode instances");
		try {
			String queryString = "from CountryCode";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CountryCode merge(CountryCode detachedInstance) {
        log.debug("merging CountryCode instance");
        try {
            CountryCode result = (CountryCode) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CountryCode instance) {
        log.debug("attaching dirty CountryCode instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CountryCode instance) {
        log.debug("attaching clean CountryCode instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}