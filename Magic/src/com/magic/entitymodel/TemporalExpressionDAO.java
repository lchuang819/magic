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
 	* A data access object (DAO) providing persistence and search support for TemporalExpression entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.TemporalExpression
  * @author MyEclipse Persistence Tools 
 */

public class TemporalExpressionDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(TemporalExpressionDAO.class);
	//property constants
	public static final String TEMP_EXPR_TYPE_ID = "tempExprTypeId";
	public static final String STRING1 = "string1";
	public static final String STRING2 = "string2";



    
    public void save(TemporalExpression transientInstance) {
        log.debug("saving TemporalExpression instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TemporalExpression persistentInstance) {
        log.debug("deleting TemporalExpression instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TemporalExpression findById( java.lang.String id) {
        log.debug("getting TemporalExpression instance with id: " + id);
        try {
            TemporalExpression instance = (TemporalExpression) getSession()
                    .get("com.magic.entitymodel.TemporalExpression", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TemporalExpression instance) {
        log.debug("finding TemporalExpression instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.TemporalExpression")
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
      log.debug("finding TemporalExpression instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TemporalExpression as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTempExprTypeId(Object tempExprTypeId
	) {
		return findByProperty(TEMP_EXPR_TYPE_ID, tempExprTypeId
		);
	}
	
	public List findByString1(Object string1
	) {
		return findByProperty(STRING1, string1
		);
	}
	
	public List findByString2(Object string2
	) {
		return findByProperty(STRING2, string2
		);
	}
	

	public List findAll() {
		log.debug("finding all TemporalExpression instances");
		try {
			String queryString = "from TemporalExpression";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TemporalExpression merge(TemporalExpression detachedInstance) {
        log.debug("merging TemporalExpression instance");
        try {
            TemporalExpression result = (TemporalExpression) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TemporalExpression instance) {
        log.debug("attaching dirty TemporalExpression instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TemporalExpression instance) {
        log.debug("attaching clean TemporalExpression instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}