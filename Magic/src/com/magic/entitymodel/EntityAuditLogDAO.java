package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntityAuditLog entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntityAuditLog
  * @author MyEclipse Persistence Tools 
 */

public class EntityAuditLogDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntityAuditLogDAO.class);
	//property constants
	public static final String CHANGED_ENTITY_NAME = "changedEntityName";
	public static final String CHANGED_FIELD_NAME = "changedFieldName";
	public static final String PK_COMBINED_VALUE_TEXT = "pkCombinedValueText";
	public static final String OLD_VALUE_TEXT = "oldValueText";
	public static final String NEW_VALUE_TEXT = "newValueText";
	public static final String CHANGED_BY_INFO = "changedByInfo";
	public static final String CHANGED_SESSION_INFO = "changedSessionInfo";



    
    public void save(EntityAuditLog transientInstance) {
        log.debug("saving EntityAuditLog instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntityAuditLog persistentInstance) {
        log.debug("deleting EntityAuditLog instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntityAuditLog findById( java.lang.String id) {
        log.debug("getting EntityAuditLog instance with id: " + id);
        try {
            EntityAuditLog instance = (EntityAuditLog) getSession()
                    .get("com.magic.entitymodel.EntityAuditLog", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntityAuditLog instance) {
        log.debug("finding EntityAuditLog instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntityAuditLog")
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
      log.debug("finding EntityAuditLog instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntityAuditLog as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByChangedEntityName(Object changedEntityName
	) {
		return findByProperty(CHANGED_ENTITY_NAME, changedEntityName
		);
	}
	
	public List findByChangedFieldName(Object changedFieldName
	) {
		return findByProperty(CHANGED_FIELD_NAME, changedFieldName
		);
	}
	
	public List findByPkCombinedValueText(Object pkCombinedValueText
	) {
		return findByProperty(PK_COMBINED_VALUE_TEXT, pkCombinedValueText
		);
	}
	
	public List findByOldValueText(Object oldValueText
	) {
		return findByProperty(OLD_VALUE_TEXT, oldValueText
		);
	}
	
	public List findByNewValueText(Object newValueText
	) {
		return findByProperty(NEW_VALUE_TEXT, newValueText
		);
	}
	
	public List findByChangedByInfo(Object changedByInfo
	) {
		return findByProperty(CHANGED_BY_INFO, changedByInfo
		);
	}
	
	public List findByChangedSessionInfo(Object changedSessionInfo
	) {
		return findByProperty(CHANGED_SESSION_INFO, changedSessionInfo
		);
	}
	

	public List findAll() {
		log.debug("finding all EntityAuditLog instances");
		try {
			String queryString = "from EntityAuditLog";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntityAuditLog merge(EntityAuditLog detachedInstance) {
        log.debug("merging EntityAuditLog instance");
        try {
            EntityAuditLog result = (EntityAuditLog) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntityAuditLog instance) {
        log.debug("attaching dirty EntityAuditLog instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntityAuditLog instance) {
        log.debug("attaching clean EntityAuditLog instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}