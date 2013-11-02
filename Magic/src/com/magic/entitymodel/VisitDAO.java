package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for Visit entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.Visit
  * @author MyEclipse Persistence Tools 
 */

public class VisitDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(VisitDAO.class);
	//property constants
	public static final String VISITOR_ID = "visitorId";
	public static final String USER_LOGIN_ID = "userLoginId";
	public static final String USER_CREATED = "userCreated";
	public static final String SESSION_ID = "sessionId";
	public static final String SERVER_IP_ADDRESS = "serverIpAddress";
	public static final String SERVER_HOST_NAME = "serverHostName";
	public static final String WEBAPP_NAME = "webappName";
	public static final String INITIAL_LOCALE = "initialLocale";
	public static final String INITIAL_REQUEST = "initialRequest";
	public static final String INITIAL_REFERRER = "initialReferrer";
	public static final String INITIAL_USER_AGENT = "initialUserAgent";
	public static final String USER_AGENT_ID = "userAgentId";
	public static final String CLIENT_IP_ADDRESS = "clientIpAddress";
	public static final String CLIENT_HOST_NAME = "clientHostName";
	public static final String CLIENT_USER = "clientUser";
	public static final String CLIENT_IP_ISP_NAME = "clientIpIspName";
	public static final String CLIENT_IP_POSTAL_CODE = "clientIpPostalCode";
	public static final String CLIENT_IP_STATE_PROV_GEO_ID = "clientIpStateProvGeoId";
	public static final String CLIENT_IP_COUNTRY_GEO_ID = "clientIpCountryGeoId";
	public static final String COOKIE = "cookie";



    
    public void save(Visit transientInstance) {
        log.debug("saving Visit instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Visit persistentInstance) {
        log.debug("deleting Visit instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Visit findById( java.lang.String id) {
        log.debug("getting Visit instance with id: " + id);
        try {
            Visit instance = (Visit) getSession()
                    .get("com.magic.entitymodel.Visit", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Visit instance) {
        log.debug("finding Visit instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.Visit")
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
      log.debug("finding Visit instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Visit as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByVisitorId(Object visitorId
	) {
		return findByProperty(VISITOR_ID, visitorId
		);
	}
	
	public List findByUserLoginId(Object userLoginId
	) {
		return findByProperty(USER_LOGIN_ID, userLoginId
		);
	}
	
	public List findByUserCreated(Object userCreated
	) {
		return findByProperty(USER_CREATED, userCreated
		);
	}
	
	public List findBySessionId(Object sessionId
	) {
		return findByProperty(SESSION_ID, sessionId
		);
	}
	
	public List findByServerIpAddress(Object serverIpAddress
	) {
		return findByProperty(SERVER_IP_ADDRESS, serverIpAddress
		);
	}
	
	public List findByServerHostName(Object serverHostName
	) {
		return findByProperty(SERVER_HOST_NAME, serverHostName
		);
	}
	
	public List findByWebappName(Object webappName
	) {
		return findByProperty(WEBAPP_NAME, webappName
		);
	}
	
	public List findByInitialLocale(Object initialLocale
	) {
		return findByProperty(INITIAL_LOCALE, initialLocale
		);
	}
	
	public List findByInitialRequest(Object initialRequest
	) {
		return findByProperty(INITIAL_REQUEST, initialRequest
		);
	}
	
	public List findByInitialReferrer(Object initialReferrer
	) {
		return findByProperty(INITIAL_REFERRER, initialReferrer
		);
	}
	
	public List findByInitialUserAgent(Object initialUserAgent
	) {
		return findByProperty(INITIAL_USER_AGENT, initialUserAgent
		);
	}
	
	public List findByUserAgentId(Object userAgentId
	) {
		return findByProperty(USER_AGENT_ID, userAgentId
		);
	}
	
	public List findByClientIpAddress(Object clientIpAddress
	) {
		return findByProperty(CLIENT_IP_ADDRESS, clientIpAddress
		);
	}
	
	public List findByClientHostName(Object clientHostName
	) {
		return findByProperty(CLIENT_HOST_NAME, clientHostName
		);
	}
	
	public List findByClientUser(Object clientUser
	) {
		return findByProperty(CLIENT_USER, clientUser
		);
	}
	
	public List findByClientIpIspName(Object clientIpIspName
	) {
		return findByProperty(CLIENT_IP_ISP_NAME, clientIpIspName
		);
	}
	
	public List findByClientIpPostalCode(Object clientIpPostalCode
	) {
		return findByProperty(CLIENT_IP_POSTAL_CODE, clientIpPostalCode
		);
	}
	
	public List findByClientIpStateProvGeoId(Object clientIpStateProvGeoId
	) {
		return findByProperty(CLIENT_IP_STATE_PROV_GEO_ID, clientIpStateProvGeoId
		);
	}
	
	public List findByClientIpCountryGeoId(Object clientIpCountryGeoId
	) {
		return findByProperty(CLIENT_IP_COUNTRY_GEO_ID, clientIpCountryGeoId
		);
	}
	
	public List findByCookie(Object cookie
	) {
		return findByProperty(COOKIE, cookie
		);
	}
	

	public List findAll() {
		log.debug("finding all Visit instances");
		try {
			String queryString = "from Visit";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Visit merge(Visit detachedInstance) {
        log.debug("merging Visit instance");
        try {
            Visit result = (Visit) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Visit instance) {
        log.debug("attaching dirty Visit instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Visit instance) {
        log.debug("attaching clean Visit instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}