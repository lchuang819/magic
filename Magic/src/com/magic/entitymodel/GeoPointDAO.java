package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for GeoPoint entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.GeoPoint
  * @author MyEclipse Persistence Tools 
 */

public class GeoPointDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(GeoPointDAO.class);
	//property constants
	public static final String DATA_SOURCE_ID = "dataSourceId";
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	public static final String ELEVATION = "elevation";
	public static final String ELEVATION_UOM_ID = "elevationUomId";
	public static final String INFORMATION = "information";



    
    public void save(GeoPoint transientInstance) {
        log.debug("saving GeoPoint instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(GeoPoint persistentInstance) {
        log.debug("deleting GeoPoint instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public GeoPoint findById( java.lang.String id) {
        log.debug("getting GeoPoint instance with id: " + id);
        try {
            GeoPoint instance = (GeoPoint) getSession()
                    .get("com.magic.entitymodel.GeoPoint", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(GeoPoint instance) {
        log.debug("finding GeoPoint instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.GeoPoint")
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
      log.debug("finding GeoPoint instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from GeoPoint as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDataSourceId(Object dataSourceId
	) {
		return findByProperty(DATA_SOURCE_ID, dataSourceId
		);
	}
	
	public List findByLatitude(Object latitude
	) {
		return findByProperty(LATITUDE, latitude
		);
	}
	
	public List findByLongitude(Object longitude
	) {
		return findByProperty(LONGITUDE, longitude
		);
	}
	
	public List findByElevation(Object elevation
	) {
		return findByProperty(ELEVATION, elevation
		);
	}
	
	public List findByElevationUomId(Object elevationUomId
	) {
		return findByProperty(ELEVATION_UOM_ID, elevationUomId
		);
	}
	
	public List findByInformation(Object information
	) {
		return findByProperty(INFORMATION, information
		);
	}
	

	public List findAll() {
		log.debug("finding all GeoPoint instances");
		try {
			String queryString = "from GeoPoint";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public GeoPoint merge(GeoPoint detachedInstance) {
        log.debug("merging GeoPoint instance");
        try {
            GeoPoint result = (GeoPoint) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(GeoPoint instance) {
        log.debug("attaching dirty GeoPoint instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(GeoPoint instance) {
        log.debug("attaching clean GeoPoint instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}