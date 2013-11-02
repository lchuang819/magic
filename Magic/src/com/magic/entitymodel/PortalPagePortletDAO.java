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
 	* A data access object (DAO) providing persistence and search support for PortalPagePortlet entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PortalPagePortlet
  * @author MyEclipse Persistence Tools 
 */

public class PortalPagePortletDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PortalPagePortletDAO.class);
	//property constants
	public static final String COLUMN_SEQ_ID = "columnSeqId";



    
    public void save(PortalPagePortlet transientInstance) {
        log.debug("saving PortalPagePortlet instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PortalPagePortlet persistentInstance) {
        log.debug("deleting PortalPagePortlet instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PortalPagePortlet findById( com.magic.entitymodel.PortalPagePortletId id) {
        log.debug("getting PortalPagePortlet instance with id: " + id);
        try {
            PortalPagePortlet instance = (PortalPagePortlet) getSession()
                    .get("com.magic.entitymodel.PortalPagePortlet", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PortalPagePortlet instance) {
        log.debug("finding PortalPagePortlet instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PortalPagePortlet")
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
      log.debug("finding PortalPagePortlet instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PortalPagePortlet as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByColumnSeqId(Object columnSeqId
	) {
		return findByProperty(COLUMN_SEQ_ID, columnSeqId
		);
	}
	

	public List findAll() {
		log.debug("finding all PortalPagePortlet instances");
		try {
			String queryString = "from PortalPagePortlet";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PortalPagePortlet merge(PortalPagePortlet detachedInstance) {
        log.debug("merging PortalPagePortlet instance");
        try {
            PortalPagePortlet result = (PortalPagePortlet) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PortalPagePortlet instance) {
        log.debug("attaching dirty PortalPagePortlet instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PortalPagePortlet instance) {
        log.debug("attaching clean PortalPagePortlet instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}