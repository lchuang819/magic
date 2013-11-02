package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for PortletAttribute entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PortletAttribute
  * @author MyEclipse Persistence Tools 
 */

public class PortletAttributeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PortletAttributeDAO.class);
	//property constants
	public static final String ATTR_VALUE = "attrValue";
	public static final String ATTR_TYPE = "attrType";



    
    public void save(PortletAttribute transientInstance) {
        log.debug("saving PortletAttribute instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PortletAttribute persistentInstance) {
        log.debug("deleting PortletAttribute instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PortletAttribute findById( com.magic.entitymodel.PortletAttributeId id) {
        log.debug("getting PortletAttribute instance with id: " + id);
        try {
            PortletAttribute instance = (PortletAttribute) getSession()
                    .get("com.magic.entitymodel.PortletAttribute", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PortletAttribute instance) {
        log.debug("finding PortletAttribute instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PortletAttribute")
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
      log.debug("finding PortletAttribute instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PortletAttribute as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAttrValue(Object attrValue
	) {
		return findByProperty(ATTR_VALUE, attrValue
		);
	}
	
	public List findByAttrType(Object attrType
	) {
		return findByProperty(ATTR_TYPE, attrType
		);
	}
	

	public List findAll() {
		log.debug("finding all PortletAttribute instances");
		try {
			String queryString = "from PortletAttribute";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PortletAttribute merge(PortletAttribute detachedInstance) {
        log.debug("merging PortletAttribute instance");
        try {
            PortletAttribute result = (PortletAttribute) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PortletAttribute instance) {
        log.debug("attaching dirty PortletAttribute instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PortletAttribute instance) {
        log.debug("attaching clean PortletAttribute instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}