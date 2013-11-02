package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for GeoAssoc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.GeoAssoc
  * @author MyEclipse Persistence Tools 
 */

public class GeoAssocDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(GeoAssocDAO.class);
	//property constants
	public static final String GEO_ASSOC_TYPE_ID = "geoAssocTypeId";



    
    public void save(GeoAssoc transientInstance) {
        log.debug("saving GeoAssoc instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(GeoAssoc persistentInstance) {
        log.debug("deleting GeoAssoc instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public GeoAssoc findById( com.magic.entitymodel.GeoAssocId id) {
        log.debug("getting GeoAssoc instance with id: " + id);
        try {
            GeoAssoc instance = (GeoAssoc) getSession()
                    .get("com.magic.entitymodel.GeoAssoc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(GeoAssoc instance) {
        log.debug("finding GeoAssoc instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.GeoAssoc")
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
      log.debug("finding GeoAssoc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from GeoAssoc as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByGeoAssocTypeId(Object geoAssocTypeId
	) {
		return findByProperty(GEO_ASSOC_TYPE_ID, geoAssocTypeId
		);
	}
	

	public List findAll() {
		log.debug("finding all GeoAssoc instances");
		try {
			String queryString = "from GeoAssoc";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public GeoAssoc merge(GeoAssoc detachedInstance) {
        log.debug("merging GeoAssoc instance");
        try {
            GeoAssoc result = (GeoAssoc) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(GeoAssoc instance) {
        log.debug("attaching dirty GeoAssoc instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(GeoAssoc instance) {
        log.debug("attaching clean GeoAssoc instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}