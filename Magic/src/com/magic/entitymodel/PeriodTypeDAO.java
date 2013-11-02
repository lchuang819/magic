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
 	* A data access object (DAO) providing persistence and search support for PeriodType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PeriodType
  * @author MyEclipse Persistence Tools 
 */

public class PeriodTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PeriodTypeDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";
	public static final String UOM_ID = "uomId";



    
    public void save(PeriodType transientInstance) {
        log.debug("saving PeriodType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PeriodType persistentInstance) {
        log.debug("deleting PeriodType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PeriodType findById( java.lang.String id) {
        log.debug("getting PeriodType instance with id: " + id);
        try {
            PeriodType instance = (PeriodType) getSession()
                    .get("com.magic.entitymodel.PeriodType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PeriodType instance) {
        log.debug("finding PeriodType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PeriodType")
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
      log.debug("finding PeriodType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PeriodType as model where model." 
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
	
	public List findByUomId(Object uomId
	) {
		return findByProperty(UOM_ID, uomId
		);
	}
	

	public List findAll() {
		log.debug("finding all PeriodType instances");
		try {
			String queryString = "from PeriodType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PeriodType merge(PeriodType detachedInstance) {
        log.debug("merging PeriodType instance");
        try {
            PeriodType result = (PeriodType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PeriodType instance) {
        log.debug("attaching dirty PeriodType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PeriodType instance) {
        log.debug("attaching clean PeriodType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}