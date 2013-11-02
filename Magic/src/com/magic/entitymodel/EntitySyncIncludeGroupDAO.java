package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntitySyncIncludeGroup entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntitySyncIncludeGroup
  * @author MyEclipse Persistence Tools 
 */

public class EntitySyncIncludeGroupDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntitySyncIncludeGroupDAO.class);
	//property constants



    
    public void save(EntitySyncIncludeGroup transientInstance) {
        log.debug("saving EntitySyncIncludeGroup instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntitySyncIncludeGroup persistentInstance) {
        log.debug("deleting EntitySyncIncludeGroup instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntitySyncIncludeGroup findById( com.magic.entitymodel.EntitySyncIncludeGroupId id) {
        log.debug("getting EntitySyncIncludeGroup instance with id: " + id);
        try {
            EntitySyncIncludeGroup instance = (EntitySyncIncludeGroup) getSession()
                    .get("com.magic.entitymodel.EntitySyncIncludeGroup", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntitySyncIncludeGroup instance) {
        log.debug("finding EntitySyncIncludeGroup instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntitySyncIncludeGroup")
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
      log.debug("finding EntitySyncIncludeGroup instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntitySyncIncludeGroup as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all EntitySyncIncludeGroup instances");
		try {
			String queryString = "from EntitySyncIncludeGroup";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntitySyncIncludeGroup merge(EntitySyncIncludeGroup detachedInstance) {
        log.debug("merging EntitySyncIncludeGroup instance");
        try {
            EntitySyncIncludeGroup result = (EntitySyncIncludeGroup) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntitySyncIncludeGroup instance) {
        log.debug("attaching dirty EntitySyncIncludeGroup instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntitySyncIncludeGroup instance) {
        log.debug("attaching clean EntitySyncIncludeGroup instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}