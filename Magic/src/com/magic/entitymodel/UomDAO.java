package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for Uom entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.Uom
  * @author MyEclipse Persistence Tools 
 */

public class UomDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UomDAO.class);
	//property constants
	public static final String UOM_TYPE_ID = "uomTypeId";
	public static final String ABBREVIATION = "abbreviation";
	public static final String DESCRIPTION = "description";



    
    public void save(Uom transientInstance) {
        log.debug("saving Uom instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Uom persistentInstance) {
        log.debug("deleting Uom instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Uom findById( java.lang.String id) {
        log.debug("getting Uom instance with id: " + id);
        try {
            Uom instance = (Uom) getSession()
                    .get("com.magic.entitymodel.Uom", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Uom instance) {
        log.debug("finding Uom instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.Uom")
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
      log.debug("finding Uom instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Uom as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUomTypeId(Object uomTypeId
	) {
		return findByProperty(UOM_TYPE_ID, uomTypeId
		);
	}
	
	public List findByAbbreviation(Object abbreviation
	) {
		return findByProperty(ABBREVIATION, abbreviation
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all Uom instances");
		try {
			String queryString = "from Uom";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Uom merge(Uom detachedInstance) {
        log.debug("merging Uom instance");
        try {
            Uom result = (Uom) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Uom instance) {
        log.debug("attaching dirty Uom instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Uom instance) {
        log.debug("attaching clean Uom instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}