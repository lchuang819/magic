package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for CountryCapital entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.CountryCapital
  * @author MyEclipse Persistence Tools 
 */

public class CountryCapitalDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(CountryCapitalDAO.class);
	//property constants
	public static final String COUNTRY_CAPITAL = "countryCapital";



    
    public void save(CountryCapital transientInstance) {
        log.debug("saving CountryCapital instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CountryCapital persistentInstance) {
        log.debug("deleting CountryCapital instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CountryCapital findById( java.lang.String id) {
        log.debug("getting CountryCapital instance with id: " + id);
        try {
            CountryCapital instance = (CountryCapital) getSession()
                    .get("com.magic.entitymodel.CountryCapital", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CountryCapital instance) {
        log.debug("finding CountryCapital instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.CountryCapital")
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
      log.debug("finding CountryCapital instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CountryCapital as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCountryCapital(Object countryCapital
	) {
		return findByProperty(COUNTRY_CAPITAL, countryCapital
		);
	}
	

	public List findAll() {
		log.debug("finding all CountryCapital instances");
		try {
			String queryString = "from CountryCapital";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CountryCapital merge(CountryCapital detachedInstance) {
        log.debug("merging CountryCapital instance");
        try {
            CountryCapital result = (CountryCapital) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CountryCapital instance) {
        log.debug("attaching dirty CountryCapital instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CountryCapital instance) {
        log.debug("attaching clean CountryCapital instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}