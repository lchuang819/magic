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
 	* A data access object (DAO) providing persistence and search support for EntitySync entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntitySync
  * @author MyEclipse Persistence Tools 
 */

public class EntitySyncDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntitySyncDAO.class);
	//property constants
	public static final String RUN_STATUS_ID = "runStatusId";
	public static final String TARGET_SERVICE_NAME = "targetServiceName";
	public static final String TARGET_DELEGATOR_NAME = "targetDelegatorName";
	public static final String KEEP_REMOVE_INFO_HOURS = "keepRemoveInfoHours";
	public static final String FOR_PULL_ONLY = "forPullOnly";
	public static final String FOR_PUSH_ONLY = "forPushOnly";



    
    public void save(EntitySync transientInstance) {
        log.debug("saving EntitySync instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntitySync persistentInstance) {
        log.debug("deleting EntitySync instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntitySync findById( java.lang.String id) {
        log.debug("getting EntitySync instance with id: " + id);
        try {
            EntitySync instance = (EntitySync) getSession()
                    .get("com.magic.entitymodel.EntitySync", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntitySync instance) {
        log.debug("finding EntitySync instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntitySync")
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
      log.debug("finding EntitySync instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntitySync as model where model." 
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
	
	public List findByTargetServiceName(Object targetServiceName
	) {
		return findByProperty(TARGET_SERVICE_NAME, targetServiceName
		);
	}
	
	public List findByTargetDelegatorName(Object targetDelegatorName
	) {
		return findByProperty(TARGET_DELEGATOR_NAME, targetDelegatorName
		);
	}
	
	public List findByKeepRemoveInfoHours(Object keepRemoveInfoHours
	) {
		return findByProperty(KEEP_REMOVE_INFO_HOURS, keepRemoveInfoHours
		);
	}
	
	public List findByForPullOnly(Object forPullOnly
	) {
		return findByProperty(FOR_PULL_ONLY, forPullOnly
		);
	}
	
	public List findByForPushOnly(Object forPushOnly
	) {
		return findByProperty(FOR_PUSH_ONLY, forPushOnly
		);
	}
	

	public List findAll() {
		log.debug("finding all EntitySync instances");
		try {
			String queryString = "from EntitySync";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntitySync merge(EntitySync detachedInstance) {
        log.debug("merging EntitySync instance");
        try {
            EntitySync result = (EntitySync) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntitySync instance) {
        log.debug("attaching dirty EntitySync instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntitySync instance) {
        log.debug("attaching clean EntitySync instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}