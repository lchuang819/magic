package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for CountryTeleCode entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.CountryTeleCode
  * @author MyEclipse Persistence Tools 
 */

public class CountryTeleCodeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(CountryTeleCodeDAO.class);
	//property constants
	public static final String TELE_CODE = "teleCode";



    
    public void save(CountryTeleCode transientInstance) {
        log.debug("saving CountryTeleCode instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CountryTeleCode persistentInstance) {
        log.debug("deleting CountryTeleCode instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CountryTeleCode findById( java.lang.String id) {
        log.debug("getting CountryTeleCode instance with id: " + id);
        try {
            CountryTeleCode instance = (CountryTeleCode) getSession()
                    .get("com.magic.entitymodel.CountryTeleCode", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CountryTeleCode instance) {
        log.debug("finding CountryTeleCode instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.CountryTeleCode")
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
      log.debug("finding CountryTeleCode instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CountryTeleCode as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTeleCode(Object teleCode
	) {
		return findByProperty(TELE_CODE, teleCode
		);
	}
	

	public List findAll() {
		log.debug("finding all CountryTeleCode instances");
		try {
			String queryString = "from CountryTeleCode";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CountryTeleCode merge(CountryTeleCode detachedInstance) {
        log.debug("merging CountryTeleCode instance");
        try {
            CountryTeleCode result = (CountryTeleCode) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CountryTeleCode instance) {
        log.debug("attaching dirty CountryTeleCode instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CountryTeleCode instance) {
        log.debug("attaching clean CountryTeleCode instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}