package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for ExampleFeature entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ExampleFeature
  * @author MyEclipse Persistence Tools 
 */

public class ExampleFeatureDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ExampleFeatureDAO.class);
	//property constants
	public static final String FEATURE_SOURCE_ENUM_ID = "featureSourceEnumId";
	public static final String DESCRIPTION = "description";



    
    public void save(ExampleFeature transientInstance) {
        log.debug("saving ExampleFeature instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ExampleFeature persistentInstance) {
        log.debug("deleting ExampleFeature instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ExampleFeature findById( java.lang.String id) {
        log.debug("getting ExampleFeature instance with id: " + id);
        try {
            ExampleFeature instance = (ExampleFeature) getSession()
                    .get("com.magic.entitymodel.ExampleFeature", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ExampleFeature instance) {
        log.debug("finding ExampleFeature instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ExampleFeature")
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
      log.debug("finding ExampleFeature instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ExampleFeature as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByFeatureSourceEnumId(Object featureSourceEnumId
	) {
		return findByProperty(FEATURE_SOURCE_ENUM_ID, featureSourceEnumId
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all ExampleFeature instances");
		try {
			String queryString = "from ExampleFeature";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ExampleFeature merge(ExampleFeature detachedInstance) {
        log.debug("merging ExampleFeature instance");
        try {
            ExampleFeature result = (ExampleFeature) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ExampleFeature instance) {
        log.debug("attaching dirty ExampleFeature instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ExampleFeature instance) {
        log.debug("attaching clean ExampleFeature instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}