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
 	* A data access object (DAO) providing persistence and search support for ServerHit entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ServerHit
  * @author MyEclipse Persistence Tools 
 */

public class ServerHitDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ServerHitDAO.class);
	//property constants
	public static final String USER_LOGIN_ID = "userLoginId";
	public static final String STATUS_ID = "statusId";
	public static final String REQUEST_URL = "requestUrl";
	public static final String REFERRER_URL = "referrerUrl";
	public static final String SERVER_IP_ADDRESS = "serverIpAddress";
	public static final String SERVER_HOST_NAME = "serverHostName";



    
    public void save(ServerHit transientInstance) {
        log.debug("saving ServerHit instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ServerHit persistentInstance) {
        log.debug("deleting ServerHit instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ServerHit findById( com.magic.entitymodel.ServerHitId id) {
        log.debug("getting ServerHit instance with id: " + id);
        try {
            ServerHit instance = (ServerHit) getSession()
                    .get("com.magic.entitymodel.ServerHit", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ServerHit instance) {
        log.debug("finding ServerHit instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ServerHit")
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
      log.debug("finding ServerHit instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ServerHit as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByUserLoginId(Object userLoginId
	) {
		return findByProperty(USER_LOGIN_ID, userLoginId
		);
	}
	
	public List findByStatusId(Object statusId
	) {
		return findByProperty(STATUS_ID, statusId
		);
	}
	
	public List findByRequestUrl(Object requestUrl
	) {
		return findByProperty(REQUEST_URL, requestUrl
		);
	}
	
	public List findByReferrerUrl(Object referrerUrl
	) {
		return findByProperty(REFERRER_URL, referrerUrl
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
	

	public List findAll() {
		log.debug("finding all ServerHit instances");
		try {
			String queryString = "from ServerHit";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ServerHit merge(ServerHit detachedInstance) {
        log.debug("merging ServerHit instance");
        try {
            ServerHit result = (ServerHit) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ServerHit instance) {
        log.debug("attaching dirty ServerHit instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ServerHit instance) {
        log.debug("attaching clean ServerHit instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}