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
 	* A data access object (DAO) providing persistence and search support for UomConversion entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UomConversion
  * @author MyEclipse Persistence Tools 
 */

public class UomConversionDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UomConversionDAO.class);
	//property constants
	public static final String CONVERSION_FACTOR = "conversionFactor";
	public static final String CUSTOM_METHOD_ID = "customMethodId";
	public static final String ROUNDING_MODE = "roundingMode";



    
    public void save(UomConversion transientInstance) {
        log.debug("saving UomConversion instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UomConversion persistentInstance) {
        log.debug("deleting UomConversion instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UomConversion findById( com.magic.entitymodel.UomConversionId id) {
        log.debug("getting UomConversion instance with id: " + id);
        try {
            UomConversion instance = (UomConversion) getSession()
                    .get("com.magic.entitymodel.UomConversion", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UomConversion instance) {
        log.debug("finding UomConversion instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UomConversion")
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
      log.debug("finding UomConversion instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UomConversion as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByConversionFactor(Object conversionFactor
	) {
		return findByProperty(CONVERSION_FACTOR, conversionFactor
		);
	}
	
	public List findByCustomMethodId(Object customMethodId
	) {
		return findByProperty(CUSTOM_METHOD_ID, customMethodId
		);
	}
	
	public List findByRoundingMode(Object roundingMode
	) {
		return findByProperty(ROUNDING_MODE, roundingMode
		);
	}
	

	public List findAll() {
		log.debug("finding all UomConversion instances");
		try {
			String queryString = "from UomConversion";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UomConversion merge(UomConversion detachedInstance) {
        log.debug("merging UomConversion instance");
        try {
            UomConversion result = (UomConversion) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UomConversion instance) {
        log.debug("attaching dirty UomConversion instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UomConversion instance) {
        log.debug("attaching clean UomConversion instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}