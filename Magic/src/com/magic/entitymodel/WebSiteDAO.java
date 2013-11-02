package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for WebSite entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.WebSite
  * @author MyEclipse Persistence Tools 
 */

public class WebSiteDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(WebSiteDAO.class);
	//property constants
	public static final String SITE_NAME = "siteName";
	public static final String HTTP_HOST = "httpHost";
	public static final String HTTP_PORT = "httpPort";
	public static final String HTTPS_HOST = "httpsHost";
	public static final String HTTPS_PORT = "httpsPort";
	public static final String ENABLE_HTTPS = "enableHttps";
	public static final String STANDARD_CONTENT_PREFIX = "standardContentPrefix";
	public static final String SECURE_CONTENT_PREFIX = "secureContentPrefix";
	public static final String COOKIE_DOMAIN = "cookieDomain";
	public static final String VISUAL_THEME_SET_ID = "visualThemeSetId";



    
    public void save(WebSite transientInstance) {
        log.debug("saving WebSite instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(WebSite persistentInstance) {
        log.debug("deleting WebSite instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public WebSite findById( java.lang.String id) {
        log.debug("getting WebSite instance with id: " + id);
        try {
            WebSite instance = (WebSite) getSession()
                    .get("com.magic.entitymodel.WebSite", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(WebSite instance) {
        log.debug("finding WebSite instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.WebSite")
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
      log.debug("finding WebSite instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from WebSite as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findBySiteName(Object siteName
	) {
		return findByProperty(SITE_NAME, siteName
		);
	}
	
	public List findByHttpHost(Object httpHost
	) {
		return findByProperty(HTTP_HOST, httpHost
		);
	}
	
	public List findByHttpPort(Object httpPort
	) {
		return findByProperty(HTTP_PORT, httpPort
		);
	}
	
	public List findByHttpsHost(Object httpsHost
	) {
		return findByProperty(HTTPS_HOST, httpsHost
		);
	}
	
	public List findByHttpsPort(Object httpsPort
	) {
		return findByProperty(HTTPS_PORT, httpsPort
		);
	}
	
	public List findByEnableHttps(Object enableHttps
	) {
		return findByProperty(ENABLE_HTTPS, enableHttps
		);
	}
	
	public List findByStandardContentPrefix(Object standardContentPrefix
	) {
		return findByProperty(STANDARD_CONTENT_PREFIX, standardContentPrefix
		);
	}
	
	public List findBySecureContentPrefix(Object secureContentPrefix
	) {
		return findByProperty(SECURE_CONTENT_PREFIX, secureContentPrefix
		);
	}
	
	public List findByCookieDomain(Object cookieDomain
	) {
		return findByProperty(COOKIE_DOMAIN, cookieDomain
		);
	}
	
	public List findByVisualThemeSetId(Object visualThemeSetId
	) {
		return findByProperty(VISUAL_THEME_SET_ID, visualThemeSetId
		);
	}
	

	public List findAll() {
		log.debug("finding all WebSite instances");
		try {
			String queryString = "from WebSite";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public WebSite merge(WebSite detachedInstance) {
        log.debug("merging WebSite instance");
        try {
            WebSite result = (WebSite) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(WebSite instance) {
        log.debug("attaching dirty WebSite instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(WebSite instance) {
        log.debug("attaching clean WebSite instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}