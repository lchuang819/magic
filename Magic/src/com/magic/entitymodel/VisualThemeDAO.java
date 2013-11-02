package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for VisualTheme entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.VisualTheme
  * @author MyEclipse Persistence Tools 
 */

public class VisualThemeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(VisualThemeDAO.class);
	//property constants
	public static final String VISUAL_THEME_SET_ID = "visualThemeSetId";
	public static final String DESCRIPTION = "description";



    
    public void save(VisualTheme transientInstance) {
        log.debug("saving VisualTheme instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(VisualTheme persistentInstance) {
        log.debug("deleting VisualTheme instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public VisualTheme findById( java.lang.String id) {
        log.debug("getting VisualTheme instance with id: " + id);
        try {
            VisualTheme instance = (VisualTheme) getSession()
                    .get("com.magic.entitymodel.VisualTheme", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(VisualTheme instance) {
        log.debug("finding VisualTheme instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.VisualTheme")
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
      log.debug("finding VisualTheme instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from VisualTheme as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByVisualThemeSetId(Object visualThemeSetId
	) {
		return findByProperty(VISUAL_THEME_SET_ID, visualThemeSetId
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all VisualTheme instances");
		try {
			String queryString = "from VisualTheme";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public VisualTheme merge(VisualTheme detachedInstance) {
        log.debug("merging VisualTheme instance");
        try {
            VisualTheme result = (VisualTheme) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(VisualTheme instance) {
        log.debug("attaching dirty VisualTheme instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(VisualTheme instance) {
        log.debug("attaching clean VisualTheme instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}