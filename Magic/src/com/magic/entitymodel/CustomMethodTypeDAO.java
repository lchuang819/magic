package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for CustomMethodType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.CustomMethodType
  * @author MyEclipse Persistence Tools 
 */

public class CustomMethodTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(CustomMethodTypeDAO.class);
	//property constants
	public static final String PARENT_TYPE_ID = "parentTypeId";
	public static final String HAS_TABLE = "hasTable";
	public static final String DESCRIPTION = "description";



    
    public void save(CustomMethodType transientInstance) {
        log.debug("saving CustomMethodType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CustomMethodType persistentInstance) {
        log.debug("deleting CustomMethodType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CustomMethodType findById( java.lang.String id) {
        log.debug("getting CustomMethodType instance with id: " + id);
        try {
            CustomMethodType instance = (CustomMethodType) getSession()
                    .get("com.magic.entitymodel.CustomMethodType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CustomMethodType instance) {
        log.debug("finding CustomMethodType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.CustomMethodType")
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
      log.debug("finding CustomMethodType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CustomMethodType as model where model." 
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
	
	public List findByHasTable(Object hasTable
	) {
		return findByProperty(HAS_TABLE, hasTable
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all CustomMethodType instances");
		try {
			String queryString = "from CustomMethodType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CustomMethodType merge(CustomMethodType detachedInstance) {
        log.debug("merging CustomMethodType instance");
        try {
            CustomMethodType result = (CustomMethodType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CustomMethodType instance) {
        log.debug("attaching dirty CustomMethodType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CustomMethodType instance) {
        log.debug("attaching clean CustomMethodType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}