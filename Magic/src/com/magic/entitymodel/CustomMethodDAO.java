package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for CustomMethod entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.CustomMethod
  * @author MyEclipse Persistence Tools 
 */

public class CustomMethodDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(CustomMethodDAO.class);
	//property constants
	public static final String CUSTOM_METHOD_TYPE_ID = "customMethodTypeId";
	public static final String CUSTOM_METHOD_NAME = "customMethodName";
	public static final String DESCRIPTION = "description";



    
    public void save(CustomMethod transientInstance) {
        log.debug("saving CustomMethod instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CustomMethod persistentInstance) {
        log.debug("deleting CustomMethod instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CustomMethod findById( java.lang.String id) {
        log.debug("getting CustomMethod instance with id: " + id);
        try {
            CustomMethod instance = (CustomMethod) getSession()
                    .get("com.magic.entitymodel.CustomMethod", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CustomMethod instance) {
        log.debug("finding CustomMethod instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.CustomMethod")
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
      log.debug("finding CustomMethod instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CustomMethod as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCustomMethodTypeId(Object customMethodTypeId
	) {
		return findByProperty(CUSTOM_METHOD_TYPE_ID, customMethodTypeId
		);
	}
	
	public List findByCustomMethodName(Object customMethodName
	) {
		return findByProperty(CUSTOM_METHOD_NAME, customMethodName
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all CustomMethod instances");
		try {
			String queryString = "from CustomMethod";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CustomMethod merge(CustomMethod detachedInstance) {
        log.debug("merging CustomMethod instance");
        try {
            CustomMethod result = (CustomMethod) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CustomMethod instance) {
        log.debug("attaching dirty CustomMethod instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CustomMethod instance) {
        log.debug("attaching clean CustomMethod instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}