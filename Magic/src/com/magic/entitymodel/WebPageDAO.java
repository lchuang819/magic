package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for WebPage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.WebPage
  * @author MyEclipse Persistence Tools 
 */

public class WebPageDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(WebPageDAO.class);
	//property constants
	public static final String PAGE_NAME = "pageName";
	public static final String WEB_SITE_ID = "webSiteId";



    
    public void save(WebPage transientInstance) {
        log.debug("saving WebPage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WebPage persistentInstance) {
        log.debug("deleting WebPage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WebPage findById( java.lang.String id) {
        log.debug("getting WebPage instance with id: " + id);
        try {
            WebPage instance = (WebPage) getSession()
                    .get("com.magic.entitymodel.WebPage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WebPage instance) {
        log.debug("finding WebPage instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.WebPage")
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
      log.debug("finding WebPage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WebPage as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPageName(Object pageName
	) {
		return findByProperty(PAGE_NAME, pageName
		);
	}
	
	public List findByWebSiteId(Object webSiteId
	) {
		return findByProperty(WEB_SITE_ID, webSiteId
		);
	}
	

	public List findAll() {
		log.debug("finding all WebPage instances");
		try {
			String queryString = "from WebPage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WebPage merge(WebPage detachedInstance) {
        log.debug("merging WebPage instance");
        try {
            WebPage result = (WebPage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WebPage instance) {
        log.debug("attaching dirty WebPage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WebPage instance) {
        log.debug("attaching clean WebPage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}