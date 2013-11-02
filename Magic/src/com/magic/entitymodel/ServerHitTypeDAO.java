package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for ServerHitType entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ServerHitType
  * @author MyEclipse Persistence Tools 
 */

public class ServerHitTypeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ServerHitTypeDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";



    
    public void save(ServerHitType transientInstance) {
        log.debug("saving ServerHitType instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ServerHitType persistentInstance) {
        log.debug("deleting ServerHitType instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ServerHitType findById( java.lang.String id) {
        log.debug("getting ServerHitType instance with id: " + id);
        try {
            ServerHitType instance = (ServerHitType) getSession()
                    .get("com.magic.entitymodel.ServerHitType", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ServerHitType instance) {
        log.debug("finding ServerHitType instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ServerHitType")
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
      log.debug("finding ServerHitType instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ServerHitType as model where model." 
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
		log.debug("finding all ServerHitType instances");
		try {
			String queryString = "from ServerHitType";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ServerHitType merge(ServerHitType detachedInstance) {
        log.debug("merging ServerHitType instance");
        try {
            ServerHitType result = (ServerHitType) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ServerHitType instance) {
        log.debug("attaching dirty ServerHitType instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ServerHitType instance) {
        log.debug("attaching clean ServerHitType instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}