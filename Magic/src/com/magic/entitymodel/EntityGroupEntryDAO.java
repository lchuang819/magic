package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntityGroupEntry entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntityGroupEntry
  * @author MyEclipse Persistence Tools 
 */

public class EntityGroupEntryDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntityGroupEntryDAO.class);
	//property constants
	public static final String APPL_ENUM_ID = "applEnumId";



    
    public void save(EntityGroupEntry transientInstance) {
        log.debug("saving EntityGroupEntry instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntityGroupEntry persistentInstance) {
        log.debug("deleting EntityGroupEntry instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntityGroupEntry findById( com.magic.entitymodel.EntityGroupEntryId id) {
        log.debug("getting EntityGroupEntry instance with id: " + id);
        try {
            EntityGroupEntry instance = (EntityGroupEntry) getSession()
                    .get("com.magic.entitymodel.EntityGroupEntry", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntityGroupEntry instance) {
        log.debug("finding EntityGroupEntry instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntityGroupEntry")
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
      log.debug("finding EntityGroupEntry instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntityGroupEntry as model where model." 
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
		log.debug("finding all EntityGroupEntry instances");
		try {
			String queryString = "from EntityGroupEntry";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntityGroupEntry merge(EntityGroupEntry detachedInstance) {
        log.debug("merging EntityGroupEntry instance");
        try {
            EntityGroupEntry result = (EntityGroupEntry) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntityGroupEntry instance) {
        log.debug("attaching dirty EntityGroupEntry instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntityGroupEntry instance) {
        log.debug("attaching clean EntityGroupEntry instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}