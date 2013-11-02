package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for TemporalExpressionAssoc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.TemporalExpressionAssoc
  * @author MyEclipse Persistence Tools 
 */

public class TemporalExpressionAssocDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(TemporalExpressionAssocDAO.class);
	//property constants
	public static final String EXPR_ASSOC_TYPE = "exprAssocType";



    
    public void save(TemporalExpressionAssoc transientInstance) {
        log.debug("saving TemporalExpressionAssoc instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TemporalExpressionAssoc persistentInstance) {
        log.debug("deleting TemporalExpressionAssoc instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TemporalExpressionAssoc findById( com.magic.entitymodel.TemporalExpressionAssocId id) {
        log.debug("getting TemporalExpressionAssoc instance with id: " + id);
        try {
            TemporalExpressionAssoc instance = (TemporalExpressionAssoc) getSession()
                    .get("com.magic.entitymodel.TemporalExpressionAssoc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TemporalExpressionAssoc instance) {
        log.debug("finding TemporalExpressionAssoc instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.TemporalExpressionAssoc")
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
      log.debug("finding TemporalExpressionAssoc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TemporalExpressionAssoc as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByExprAssocType(Object exprAssocType
	) {
		return findByProperty(EXPR_ASSOC_TYPE, exprAssocType
		);
	}
	

	public List findAll() {
		log.debug("finding all TemporalExpressionAssoc instances");
		try {
			String queryString = "from TemporalExpressionAssoc";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TemporalExpressionAssoc merge(TemporalExpressionAssoc detachedInstance) {
        log.debug("merging TemporalExpressionAssoc instance");
        try {
            TemporalExpressionAssoc result = (TemporalExpressionAssoc) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TemporalExpressionAssoc instance) {
        log.debug("attaching dirty TemporalExpressionAssoc instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TemporalExpressionAssoc instance) {
        log.debug("attaching clean TemporalExpressionAssoc instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}