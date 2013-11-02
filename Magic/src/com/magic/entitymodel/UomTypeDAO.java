package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for UomType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UomType
  * @author MyEclipse Persistence Tools 
 */

public class UomTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UomTypeDAO.class);
	//property constants
	public static final String PARENT_TYPE_ID = "parentTypeId";
	public static final String HAS_TABLE = "hasTable";
	public static final String DESCRIPTION = "description";



    
    public void save(UomType transientInstance) {
        log.debug("saving UomType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UomType persistentInstance) {
        log.debug("deleting UomType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UomType findById( java.lang.String id) {
        log.debug("getting UomType instance with id: " + id);
        try {
            UomType instance = (UomType) getSession()
                    .get("com.magic.entitymodel.UomType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UomType instance) {
        log.debug("finding UomType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UomType")
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
      log.debug("finding UomType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UomType as model where model." 
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
		log.debug("finding all UomType instances");
		try {
			String queryString = "from UomType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UomType merge(UomType detachedInstance) {
        log.debug("merging UomType instance");
        try {
            UomType result = (UomType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UomType instance) {
        log.debug("attaching dirty UomType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UomType instance) {
        log.debug("attaching clean UomType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}