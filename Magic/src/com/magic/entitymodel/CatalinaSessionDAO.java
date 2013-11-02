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
 	* A data access object (DAO) providing persistence and search support for CatalinaSession entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.CatalinaSession
  * @author MyEclipse Persistence Tools 
 */

public class CatalinaSessionDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(CatalinaSessionDAO.class);
	//property constants
	public static final String SESSION_INFO = "sessionInfo";
	public static final String IS_VALID = "isValid";



    
    public void save(CatalinaSession transientInstance) {
        log.debug("saving CatalinaSession instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CatalinaSession persistentInstance) {
        log.debug("deleting CatalinaSession instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CatalinaSession findById( java.lang.String id) {
        log.debug("getting CatalinaSession instance with id: " + id);
        try {
            CatalinaSession instance = (CatalinaSession) getSession()
                    .get("com.magic.entitymodel.CatalinaSession", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(CatalinaSession instance) {
        log.debug("finding CatalinaSession instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.CatalinaSession")
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
      log.debug("finding CatalinaSession instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CatalinaSession as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySessionInfo(Object sessionInfo
	) {
		return findByProperty(SESSION_INFO, sessionInfo
		);
	}
	
	public List findByIsValid(Object isValid
	) {
		return findByProperty(IS_VALID, isValid
		);
	}
	

	public List findAll() {
		log.debug("finding all CatalinaSession instances");
		try {
			String queryString = "from CatalinaSession";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CatalinaSession merge(CatalinaSession detachedInstance) {
        log.debug("merging CatalinaSession instance");
        try {
            CatalinaSession result = (CatalinaSession) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CatalinaSession instance) {
        log.debug("attaching dirty CatalinaSession instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CatalinaSession instance) {
        log.debug("attaching clean CatalinaSession instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}