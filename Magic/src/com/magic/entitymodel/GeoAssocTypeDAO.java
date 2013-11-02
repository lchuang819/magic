package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for GeoAssocType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.GeoAssocType
  * @author MyEclipse Persistence Tools 
 */

public class GeoAssocTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(GeoAssocTypeDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";



    
    public void save(GeoAssocType transientInstance) {
        log.debug("saving GeoAssocType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(GeoAssocType persistentInstance) {
        log.debug("deleting GeoAssocType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public GeoAssocType findById( java.lang.String id) {
        log.debug("getting GeoAssocType instance with id: " + id);
        try {
            GeoAssocType instance = (GeoAssocType) getSession()
                    .get("com.magic.entitymodel.GeoAssocType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(GeoAssocType instance) {
        log.debug("finding GeoAssocType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.GeoAssocType")
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
      log.debug("finding GeoAssocType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from GeoAssocType as model where model." 
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
		log.debug("finding all GeoAssocType instances");
		try {
			String queryString = "from GeoAssocType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public GeoAssocType merge(GeoAssocType detachedInstance) {
        log.debug("merging GeoAssocType instance");
        try {
            GeoAssocType result = (GeoAssocType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(GeoAssocType instance) {
        log.debug("attaching dirty GeoAssocType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(GeoAssocType instance) {
        log.debug("attaching clean GeoAssocType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}