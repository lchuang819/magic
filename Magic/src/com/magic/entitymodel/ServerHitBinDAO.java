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
 	* A data access object (DAO) providing persistence and search support for ServerHitBin entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ServerHitBin
  * @author MyEclipse Persistence Tools 
 */

public class ServerHitBinDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ServerHitBinDAO.class);
	//property constants
	public static final String CONTENT_ID = "contentId";
	public static final String HIT_TYPE_ID = "hitTypeId";
	public static final String SERVER_IP_ADDRESS = "serverIpAddress";
	public static final String SERVER_HOST_NAME = "serverHostName";



    
    public void save(ServerHitBin transientInstance) {
        log.debug("saving ServerHitBin instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ServerHitBin persistentInstance) {
        log.debug("deleting ServerHitBin instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ServerHitBin findById( java.lang.String id) {
        log.debug("getting ServerHitBin instance with id: " + id);
        try {
            ServerHitBin instance = (ServerHitBin) getSession()
                    .get("com.magic.entitymodel.ServerHitBin", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ServerHitBin instance) {
        log.debug("finding ServerHitBin instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ServerHitBin")
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
      log.debug("finding ServerHitBin instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ServerHitBin as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByContentId(Object contentId
	) {
		return findByProperty(CONTENT_ID, contentId
		);
	}
	
	public List findByHitTypeId(Object hitTypeId
	) {
		return findByProperty(HIT_TYPE_ID, hitTypeId
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
		log.debug("finding all ServerHitBin instances");
		try {
			String queryString = "from ServerHitBin";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ServerHitBin merge(ServerHitBin detachedInstance) {
        log.debug("merging ServerHitBin instance");
        try {
            ServerHitBin result = (ServerHitBin) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ServerHitBin instance) {
        log.debug("attaching dirty ServerHitBin instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ServerHitBin instance) {
        log.debug("attaching clean ServerHitBin instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}