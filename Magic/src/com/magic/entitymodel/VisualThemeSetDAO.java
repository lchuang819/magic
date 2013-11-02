package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for VisualThemeSet entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.VisualThemeSet
  * @author MyEclipse Persistence Tools 
 */

public class VisualThemeSetDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(VisualThemeSetDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";



    
    public void save(VisualThemeSet transientInstance) {
        log.debug("saving VisualThemeSet instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(VisualThemeSet persistentInstance) {
        log.debug("deleting VisualThemeSet instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public VisualThemeSet findById( java.lang.String id) {
        log.debug("getting VisualThemeSet instance with id: " + id);
        try {
            VisualThemeSet instance = (VisualThemeSet) getSession()
                    .get("com.magic.entitymodel.VisualThemeSet", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(VisualThemeSet instance) {
        log.debug("finding VisualThemeSet instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.VisualThemeSet")
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
      log.debug("finding VisualThemeSet instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from VisualThemeSet as model where model." 
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
	

	public List findAll() {
		log.debug("finding all VisualThemeSet instances");
		try {
			String queryString = "from VisualThemeSet";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public VisualThemeSet merge(VisualThemeSet detachedInstance) {
        log.debug("merging VisualThemeSet instance");
        try {
            VisualThemeSet result = (VisualThemeSet) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(VisualThemeSet instance) {
        log.debug("attaching dirty VisualThemeSet instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(VisualThemeSet instance) {
        log.debug("attaching clean VisualThemeSet instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}