package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for VisualThemeResource entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.VisualThemeResource
  * @author MyEclipse Persistence Tools 
 */

public class VisualThemeResourceDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(VisualThemeResourceDAO.class);
	//property constants
	public static final String RESOURCE_VALUE = "resourceValue";



    
    public void save(VisualThemeResource transientInstance) {
        log.debug("saving VisualThemeResource instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(VisualThemeResource persistentInstance) {
        log.debug("deleting VisualThemeResource instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public VisualThemeResource findById( com.magic.entitymodel.VisualThemeResourceId id) {
        log.debug("getting VisualThemeResource instance with id: " + id);
        try {
            VisualThemeResource instance = (VisualThemeResource) getSession()
                    .get("com.magic.entitymodel.VisualThemeResource", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(VisualThemeResource instance) {
        log.debug("finding VisualThemeResource instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.VisualThemeResource")
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
      log.debug("finding VisualThemeResource instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from VisualThemeResource as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByResourceValue(Object resourceValue
	) {
		return findByProperty(RESOURCE_VALUE, resourceValue
		);
	}
	

	public List findAll() {
		log.debug("finding all VisualThemeResource instances");
		try {
			String queryString = "from VisualThemeResource";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public VisualThemeResource merge(VisualThemeResource detachedInstance) {
        log.debug("merging VisualThemeResource instance");
        try {
            VisualThemeResource result = (VisualThemeResource) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(VisualThemeResource instance) {
        log.debug("attaching dirty VisualThemeResource instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(VisualThemeResource instance) {
        log.debug("attaching clean VisualThemeResource instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}