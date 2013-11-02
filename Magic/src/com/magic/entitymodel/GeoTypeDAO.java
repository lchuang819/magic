package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for GeoType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.GeoType
  * @author MyEclipse Persistence Tools 
 */

public class GeoTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(GeoTypeDAO.class);
	//property constants
	public static final String PARENT_TYPE_ID = "parentTypeId";
	public static final String HAS_TABLE = "hasTable";
	public static final String DESCRIPTION = "description";



    
    public void save(GeoType transientInstance) {
        log.debug("saving GeoType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(GeoType persistentInstance) {
        log.debug("deleting GeoType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public GeoType findById( java.lang.String id) {
        log.debug("getting GeoType instance with id: " + id);
        try {
            GeoType instance = (GeoType) getSession()
                    .get("com.magic.entitymodel.GeoType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(GeoType instance) {
        log.debug("finding GeoType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.GeoType")
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
      log.debug("finding GeoType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from GeoType as model where model." 
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
		log.debug("finding all GeoType instances");
		try {
			String queryString = "from GeoType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public GeoType merge(GeoType detachedInstance) {
        log.debug("merging GeoType instance");
        try {
            GeoType result = (GeoType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(GeoType instance) {
        log.debug("attaching dirty GeoType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(GeoType instance) {
        log.debug("attaching clean GeoType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}