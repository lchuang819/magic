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
 	* A data access object (DAO) providing persistence and search support for PortalPageColumn entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PortalPageColumn
  * @author MyEclipse Persistence Tools 
 */

public class PortalPageColumnDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PortalPageColumnDAO.class);
	//property constants



    
    public void save(PortalPageColumn transientInstance) {
        log.debug("saving PortalPageColumn instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PortalPageColumn persistentInstance) {
        log.debug("deleting PortalPageColumn instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PortalPageColumn findById( com.magic.entitymodel.PortalPageColumnId id) {
        log.debug("getting PortalPageColumn instance with id: " + id);
        try {
            PortalPageColumn instance = (PortalPageColumn) getSession()
                    .get("com.magic.entitymodel.PortalPageColumn", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PortalPageColumn instance) {
        log.debug("finding PortalPageColumn instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PortalPageColumn")
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
      log.debug("finding PortalPageColumn instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PortalPageColumn as model where model." 
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
		log.debug("finding all PortalPageColumn instances");
		try {
			String queryString = "from PortalPageColumn";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PortalPageColumn merge(PortalPageColumn detachedInstance) {
        log.debug("merging PortalPageColumn instance");
        try {
            PortalPageColumn result = (PortalPageColumn) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PortalPageColumn instance) {
        log.debug("attaching dirty PortalPageColumn instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PortalPageColumn instance) {
        log.debug("attaching clean PortalPageColumn instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}