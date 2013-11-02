package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for PortletPortletCategory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PortletPortletCategory
  * @author MyEclipse Persistence Tools 
 */

public class PortletPortletCategoryDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PortletPortletCategoryDAO.class);
	//property constants



    
    public void save(PortletPortletCategory transientInstance) {
        log.debug("saving PortletPortletCategory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PortletPortletCategory persistentInstance) {
        log.debug("deleting PortletPortletCategory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PortletPortletCategory findById( com.magic.entitymodel.PortletPortletCategoryId id) {
        log.debug("getting PortletPortletCategory instance with id: " + id);
        try {
            PortletPortletCategory instance = (PortletPortletCategory) getSession()
                    .get("com.magic.entitymodel.PortletPortletCategory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PortletPortletCategory instance) {
        log.debug("finding PortletPortletCategory instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PortletPortletCategory")
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
      log.debug("finding PortletPortletCategory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PortletPortletCategory as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all PortletPortletCategory instances");
		try {
			String queryString = "from PortletPortletCategory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PortletPortletCategory merge(PortletPortletCategory detachedInstance) {
        log.debug("merging PortletPortletCategory instance");
        try {
            PortletPortletCategory result = (PortletPortletCategory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PortletPortletCategory instance) {
        log.debug("attaching dirty PortletPortletCategory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PortletPortletCategory instance) {
        log.debug("attaching clean PortletPortletCategory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}