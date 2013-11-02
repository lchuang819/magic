package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for PortletCategory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PortletCategory
  * @author MyEclipse Persistence Tools 
 */

public class PortletCategoryDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PortletCategoryDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";



    
    public void save(PortletCategory transientInstance) {
        log.debug("saving PortletCategory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PortletCategory persistentInstance) {
        log.debug("deleting PortletCategory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PortletCategory findById( java.lang.String id) {
        log.debug("getting PortletCategory instance with id: " + id);
        try {
            PortletCategory instance = (PortletCategory) getSession()
                    .get("com.magic.entitymodel.PortletCategory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PortletCategory instance) {
        log.debug("finding PortletCategory instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PortletCategory")
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
      log.debug("finding PortletCategory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PortletCategory as model where model." 
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
		log.debug("finding all PortletCategory instances");
		try {
			String queryString = "from PortletCategory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PortletCategory merge(PortletCategory detachedInstance) {
        log.debug("merging PortletCategory instance");
        try {
            PortletCategory result = (PortletCategory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PortletCategory instance) {
        log.debug("attaching dirty PortletCategory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PortletCategory instance) {
        log.debug("attaching clean PortletCategory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}