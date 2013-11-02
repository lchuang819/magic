package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntitySyncHistory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntitySyncHistory
  * @author MyEclipse Persistence Tools 
 */

public class EntitySyncHistoryDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntitySyncHistoryDAO.class);
	//property constants
	public static final String RUN_STATUS_ID = "runStatusId";



    
    public void save(EntitySyncHistory transientInstance) {
        log.debug("saving EntitySyncHistory instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntitySyncHistory persistentInstance) {
        log.debug("deleting EntitySyncHistory instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntitySyncHistory findById( com.magic.entitymodel.EntitySyncHistoryId id) {
        log.debug("getting EntitySyncHistory instance with id: " + id);
        try {
            EntitySyncHistory instance = (EntitySyncHistory) getSession()
                    .get("com.magic.entitymodel.EntitySyncHistory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntitySyncHistory instance) {
        log.debug("finding EntitySyncHistory instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntitySyncHistory")
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
      log.debug("finding EntitySyncHistory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntitySyncHistory as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRunStatusId(Object runStatusId
	) {
		return findByProperty(RUN_STATUS_ID, runStatusId
		);
	}
	

	public List findAll() {
		log.debug("finding all EntitySyncHistory instances");
		try {
			String queryString = "from EntitySyncHistory";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntitySyncHistory merge(EntitySyncHistory detachedInstance) {
        log.debug("merging EntitySyncHistory instance");
        try {
            EntitySyncHistory result = (EntitySyncHistory) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntitySyncHistory instance) {
        log.debug("attaching dirty EntitySyncHistory instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntitySyncHistory instance) {
        log.debug("attaching clean EntitySyncHistory instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}