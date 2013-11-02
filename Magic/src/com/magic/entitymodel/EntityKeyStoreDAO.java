package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EntityKeyStore entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EntityKeyStore
  * @author MyEclipse Persistence Tools 
 */

public class EntityKeyStoreDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EntityKeyStoreDAO.class);
	//property constants
	public static final String KEY_TEXT = "keyText";



    
    public void save(EntityKeyStore transientInstance) {
        log.debug("saving EntityKeyStore instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EntityKeyStore persistentInstance) {
        log.debug("deleting EntityKeyStore instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EntityKeyStore findById( java.lang.String id) {
        log.debug("getting EntityKeyStore instance with id: " + id);
        try {
            EntityKeyStore instance = (EntityKeyStore) getSession()
                    .get("com.magic.entitymodel.EntityKeyStore", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EntityKeyStore instance) {
        log.debug("finding EntityKeyStore instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EntityKeyStore")
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
      log.debug("finding EntityKeyStore instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EntityKeyStore as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByKeyText(Object keyText
	) {
		return findByProperty(KEY_TEXT, keyText
		);
	}
	

	public List findAll() {
		log.debug("finding all EntityKeyStore instances");
		try {
			String queryString = "from EntityKeyStore";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EntityKeyStore merge(EntityKeyStore detachedInstance) {
        log.debug("merging EntityKeyStore instance");
        try {
            EntityKeyStore result = (EntityKeyStore) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EntityKeyStore instance) {
        log.debug("attaching dirty EntityKeyStore instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EntityKeyStore instance) {
        log.debug("attaching clean EntityKeyStore instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}