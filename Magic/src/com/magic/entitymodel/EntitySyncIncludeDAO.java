package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntitySyncInclude entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntitySyncInclude
  * @author MyEclipse Persistence Tools 
 */

public class EntitySyncIncludeDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntitySyncIncludeDAO.class);
	//property constants
	public static final String APPL_ENUM_ID = "applEnumId";



    
    public void save(EntitySyncInclude transientInstance) {
        log.debug("saving EntitySyncInclude instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntitySyncInclude persistentInstance) {
        log.debug("deleting EntitySyncInclude instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntitySyncInclude findById( com.magic.entitymodel.EntitySyncIncludeId id) {
        log.debug("getting EntitySyncInclude instance with id: " + id);
        try {
            EntitySyncInclude instance = (EntitySyncInclude) getSession()
                    .get("com.magic.entitymodel.EntitySyncInclude", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntitySyncInclude instance) {
        log.debug("finding EntitySyncInclude instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntitySyncInclude")
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
      log.debug("finding EntitySyncInclude instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntitySyncInclude as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByApplEnumId(Object applEnumId
	) {
		return findByProperty(APPL_ENUM_ID, applEnumId
		);
	}
	

	public List findAll() {
		log.debug("finding all EntitySyncInclude instances");
		try {
			String queryString = "from EntitySyncInclude";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntitySyncInclude merge(EntitySyncInclude detachedInstance) {
        log.debug("merging EntitySyncInclude instance");
        try {
            EntitySyncInclude result = (EntitySyncInclude) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntitySyncInclude instance) {
        log.debug("attaching dirty EntitySyncInclude instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntitySyncInclude instance) {
        log.debug("attaching clean EntitySyncInclude instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}