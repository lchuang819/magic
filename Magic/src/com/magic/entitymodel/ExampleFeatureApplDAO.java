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
 	* A data access object (DAO) providing persistence and search support for ExampleFeatureAppl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ExampleFeatureAppl
  * @author MyEclipse Persistence Tools 
 */

public class ExampleFeatureApplDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ExampleFeatureApplDAO.class);
	//property constants
	public static final String EXAMPLE_FEATURE_APPL_TYPE_ID = "exampleFeatureApplTypeId";



    
    public void save(ExampleFeatureAppl transientInstance) {
        log.debug("saving ExampleFeatureAppl instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ExampleFeatureAppl persistentInstance) {
        log.debug("deleting ExampleFeatureAppl instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ExampleFeatureAppl findById( com.magic.entitymodel.ExampleFeatureApplId id) {
        log.debug("getting ExampleFeatureAppl instance with id: " + id);
        try {
            ExampleFeatureAppl instance = (ExampleFeatureAppl) getSession()
                    .get("com.magic.entitymodel.ExampleFeatureAppl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ExampleFeatureAppl instance) {
        log.debug("finding ExampleFeatureAppl instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ExampleFeatureAppl")
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
      log.debug("finding ExampleFeatureAppl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ExampleFeatureAppl as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByExampleFeatureApplTypeId(Object exampleFeatureApplTypeId
	) {
		return findByProperty(EXAMPLE_FEATURE_APPL_TYPE_ID, exampleFeatureApplTypeId
		);
	}
	

	public List findAll() {
		log.debug("finding all ExampleFeatureAppl instances");
		try {
			String queryString = "from ExampleFeatureAppl";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ExampleFeatureAppl merge(ExampleFeatureAppl detachedInstance) {
        log.debug("merging ExampleFeatureAppl instance");
        try {
            ExampleFeatureAppl result = (ExampleFeatureAppl) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ExampleFeatureAppl instance) {
        log.debug("attaching dirty ExampleFeatureAppl instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ExampleFeatureAppl instance) {
        log.debug("attaching clean ExampleFeatureAppl instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}