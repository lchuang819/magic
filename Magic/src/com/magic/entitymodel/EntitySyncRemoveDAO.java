package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntitySyncRemove entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntitySyncRemove
  * @author MyEclipse Persistence Tools 
 */

public class EntitySyncRemoveDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntitySyncRemoveDAO.class);
	//property constants
	public static final String PRIMARY_KEY_REMOVED = "primaryKeyRemoved";



    
    public void save(EntitySyncRemove transientInstance) {
        log.debug("saving EntitySyncRemove instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntitySyncRemove persistentInstance) {
        log.debug("deleting EntitySyncRemove instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntitySyncRemove findById( java.lang.String id) {
        log.debug("getting EntitySyncRemove instance with id: " + id);
        try {
            EntitySyncRemove instance = (EntitySyncRemove) getSession()
                    .get("com.magic.entitymodel.EntitySyncRemove", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntitySyncRemove instance) {
        log.debug("finding EntitySyncRemove instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntitySyncRemove")
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
      log.debug("finding EntitySyncRemove instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntitySyncRemove as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPrimaryKeyRemoved(Object primaryKeyRemoved
	) {
		return findByProperty(PRIMARY_KEY_REMOVED, primaryKeyRemoved
		);
	}
	

	public List findAll() {
		log.debug("finding all EntitySyncRemove instances");
		try {
			String queryString = "from EntitySyncRemove";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntitySyncRemove merge(EntitySyncRemove detachedInstance) {
        log.debug("merging EntitySyncRemove instance");
        try {
            EntitySyncRemove result = (EntitySyncRemove) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntitySyncRemove instance) {
        log.debug("attaching dirty EntitySyncRemove instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntitySyncRemove instance) {
        log.debug("attaching clean EntitySyncRemove instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}