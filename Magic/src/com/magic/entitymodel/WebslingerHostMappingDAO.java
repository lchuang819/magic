package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for WebslingerHostMapping entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.WebslingerHostMapping
  * @author MyEclipse Persistence Tools 
 */

public class WebslingerHostMappingDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(WebslingerHostMappingDAO.class);
	//property constants
	public static final String WEBSLINGER_SERVER_ID = "webslingerServerId";



    
    public void save(WebslingerHostMapping transientInstance) {
        log.debug("saving WebslingerHostMapping instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WebslingerHostMapping persistentInstance) {
        log.debug("deleting WebslingerHostMapping instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WebslingerHostMapping findById( com.magic.entitymodel.WebslingerHostMappingId id) {
        log.debug("getting WebslingerHostMapping instance with id: " + id);
        try {
            WebslingerHostMapping instance = (WebslingerHostMapping) getSession()
                    .get("com.magic.entitymodel.WebslingerHostMapping", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WebslingerHostMapping instance) {
        log.debug("finding WebslingerHostMapping instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.WebslingerHostMapping")
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
      log.debug("finding WebslingerHostMapping instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WebslingerHostMapping as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByWebslingerServerId(Object webslingerServerId
	) {
		return findByProperty(WEBSLINGER_SERVER_ID, webslingerServerId
		);
	}
	

	public List findAll() {
		log.debug("finding all WebslingerHostMapping instances");
		try {
			String queryString = "from WebslingerHostMapping";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WebslingerHostMapping merge(WebslingerHostMapping detachedInstance) {
        log.debug("merging WebslingerHostMapping instance");
        try {
            WebslingerHostMapping result = (WebslingerHostMapping) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WebslingerHostMapping instance) {
        log.debug("attaching dirty WebslingerHostMapping instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WebslingerHostMapping instance) {
        log.debug("attaching clean WebslingerHostMapping instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}