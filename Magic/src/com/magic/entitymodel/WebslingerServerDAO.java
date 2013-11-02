package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for WebslingerServer entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.WebslingerServer
  * @author MyEclipse Persistence Tools 
 */

public class WebslingerServerDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(WebslingerServerDAO.class);
	//property constants
	public static final String DELEGATOR_NAME = "delegatorName";
	public static final String DISPATCHER_NAME = "dispatcherName";
	public static final String SERVER_NAME = "serverName";
	public static final String WEB_SITE_ID = "webSiteId";
	public static final String TARGET = "target";
	public static final String LOAD_AT_START = "loadAtStart";



    
    public void save(WebslingerServer transientInstance) {
        log.debug("saving WebslingerServer instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WebslingerServer persistentInstance) {
        log.debug("deleting WebslingerServer instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WebslingerServer findById( java.lang.String id) {
        log.debug("getting WebslingerServer instance with id: " + id);
        try {
            WebslingerServer instance = (WebslingerServer) getSession()
                    .get("com.magic.entitymodel.WebslingerServer", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WebslingerServer instance) {
        log.debug("finding WebslingerServer instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.WebslingerServer")
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
      log.debug("finding WebslingerServer instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WebslingerServer as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDelegatorName(Object delegatorName
	) {
		return findByProperty(DELEGATOR_NAME, delegatorName
		);
	}
	
	public List findByDispatcherName(Object dispatcherName
	) {
		return findByProperty(DISPATCHER_NAME, dispatcherName
		);
	}
	
	public List findByServerName(Object serverName
	) {
		return findByProperty(SERVER_NAME, serverName
		);
	}
	
	public List findByWebSiteId(Object webSiteId
	) {
		return findByProperty(WEB_SITE_ID, webSiteId
		);
	}
	
	public List findByTarget(Object target
	) {
		return findByProperty(TARGET, target
		);
	}
	
	public List findByLoadAtStart(Object loadAtStart
	) {
		return findByProperty(LOAD_AT_START, loadAtStart
		);
	}
	

	public List findAll() {
		log.debug("finding all WebslingerServer instances");
		try {
			String queryString = "from WebslingerServer";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WebslingerServer merge(WebslingerServer detachedInstance) {
        log.debug("merging WebslingerServer instance");
        try {
            WebslingerServer result = (WebslingerServer) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WebslingerServer instance) {
        log.debug("attaching dirty WebslingerServer instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WebslingerServer instance) {
        log.debug("attaching clean WebslingerServer instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}