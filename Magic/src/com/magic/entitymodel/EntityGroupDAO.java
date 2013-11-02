package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntityGroup entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntityGroup
  * @author MyEclipse Persistence Tools 
 */

public class EntityGroupDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntityGroupDAO.class);
	//property constants
	public static final String ENTITY_GROUP_NAME = "entityGroupName";



    
    public void save(EntityGroup transientInstance) {
        log.debug("saving EntityGroup instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntityGroup persistentInstance) {
        log.debug("deleting EntityGroup instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntityGroup findById( java.lang.String id) {
        log.debug("getting EntityGroup instance with id: " + id);
        try {
            EntityGroup instance = (EntityGroup) getSession()
                    .get("com.magic.entitymodel.EntityGroup", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntityGroup instance) {
        log.debug("finding EntityGroup instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntityGroup")
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
      log.debug("finding EntityGroup instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntityGroup as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByEntityGroupName(Object entityGroupName
	) {
		return findByProperty(ENTITY_GROUP_NAME, entityGroupName
		);
	}
	

	public List findAll() {
		log.debug("finding all EntityGroup instances");
		try {
			String queryString = "from EntityGroup";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntityGroup merge(EntityGroup detachedInstance) {
        log.debug("merging EntityGroup instance");
        try {
            EntityGroup result = (EntityGroup) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntityGroup instance) {
        log.debug("attaching dirty EntityGroup instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntityGroup instance) {
        log.debug("attaching clean EntityGroup instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}