package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for ExampleFeatureApplType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ExampleFeatureApplType
  * @author MyEclipse Persistence Tools 
 */

public class ExampleFeatureApplTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ExampleFeatureApplTypeDAO.class);
	//property constants
	public static final String PARENT_TYPE_ID = "parentTypeId";
	public static final String DESCRIPTION = "description";



    
    public void save(ExampleFeatureApplType transientInstance) {
        log.debug("saving ExampleFeatureApplType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ExampleFeatureApplType persistentInstance) {
        log.debug("deleting ExampleFeatureApplType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ExampleFeatureApplType findById( java.lang.String id) {
        log.debug("getting ExampleFeatureApplType instance with id: " + id);
        try {
            ExampleFeatureApplType instance = (ExampleFeatureApplType) getSession()
                    .get("com.magic.entitymodel.ExampleFeatureApplType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ExampleFeatureApplType instance) {
        log.debug("finding ExampleFeatureApplType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ExampleFeatureApplType")
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
      log.debug("finding ExampleFeatureApplType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ExampleFeatureApplType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByParentTypeId(Object parentTypeId
	) {
		return findByProperty(PARENT_TYPE_ID, parentTypeId
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all ExampleFeatureApplType instances");
		try {
			String queryString = "from ExampleFeatureApplType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ExampleFeatureApplType merge(ExampleFeatureApplType detachedInstance) {
        log.debug("merging ExampleFeatureApplType instance");
        try {
            ExampleFeatureApplType result = (ExampleFeatureApplType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ExampleFeatureApplType instance) {
        log.debug("attaching dirty ExampleFeatureApplType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ExampleFeatureApplType instance) {
        log.debug("attaching clean ExampleFeatureApplType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}