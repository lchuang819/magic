package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for ProtocolType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ProtocolType
  * @author MyEclipse Persistence Tools 
 */

public class ProtocolTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ProtocolTypeDAO.class);
	//property constants
	public static final String PROTOCOL_NAME = "protocolName";



    
    public void save(ProtocolType transientInstance) {
        log.debug("saving ProtocolType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProtocolType persistentInstance) {
        log.debug("deleting ProtocolType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProtocolType findById( java.lang.String id) {
        log.debug("getting ProtocolType instance with id: " + id);
        try {
            ProtocolType instance = (ProtocolType) getSession()
                    .get("com.magic.entitymodel.ProtocolType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProtocolType instance) {
        log.debug("finding ProtocolType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ProtocolType")
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
      log.debug("finding ProtocolType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProtocolType as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByProtocolName(Object protocolName
	) {
		return findByProperty(PROTOCOL_NAME, protocolName
		);
	}
	

	public List findAll() {
		log.debug("finding all ProtocolType instances");
		try {
			String queryString = "from ProtocolType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProtocolType merge(ProtocolType detachedInstance) {
        log.debug("merging ProtocolType instance");
        try {
            ProtocolType result = (ProtocolType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProtocolType instance) {
        log.debug("attaching dirty ProtocolType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProtocolType instance) {
        log.debug("attaching clean ProtocolType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}