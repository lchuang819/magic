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
 	* A data access object (DAO) providing persistence and search support for UserLogin entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.UserLogin
  * @author MyEclipse Persistence Tools 
 */

public class UserLoginDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(UserLoginDAO.class);
	//property constants
	public static final String CURRENT_PASSWORD = "currentPassword";
	public static final String PASSWORD_HINT = "passwordHint";
	public static final String IS_SYSTEM = "isSystem";
	public static final String ENABLED = "enabled";
	public static final String HAS_LOGGED_OUT = "hasLoggedOut";
	public static final String REQUIRE_PASSWORD_CHANGE = "requirePasswordChange";
	public static final String LAST_CURRENCY_UOM = "lastCurrencyUom";
	public static final String LAST_LOCALE = "lastLocale";
	public static final String LAST_TIME_ZONE = "lastTimeZone";
	public static final String USER_LDAP_DN = "userLdapDn";



    
    public void save(UserLogin transientInstance) {
        log.debug("saving UserLogin instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserLogin persistentInstance) {
        log.debug("deleting UserLogin instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserLogin findById( java.lang.String id) {
        log.debug("getting UserLogin instance with id: " + id);
        try {
            UserLogin instance = (UserLogin) getSession()
                    .get("com.magic.entitymodel.UserLogin", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(UserLogin instance) {
        log.debug("finding UserLogin instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.UserLogin")
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
      log.debug("finding UserLogin instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserLogin as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCurrentPassword(Object currentPassword
	) {
		return findByProperty(CURRENT_PASSWORD, currentPassword
		);
	}
	
	public List findByPasswordHint(Object passwordHint
	) {
		return findByProperty(PASSWORD_HINT, passwordHint
		);
	}
	
	public List findByIsSystem(Object isSystem
	) {
		return findByProperty(IS_SYSTEM, isSystem
		);
	}
	
	public List findByEnabled(Object enabled
	) {
		return findByProperty(ENABLED, enabled
		);
	}
	
	public List findByHasLoggedOut(Object hasLoggedOut
	) {
		return findByProperty(HAS_LOGGED_OUT, hasLoggedOut
		);
	}
	
	public List findByRequirePasswordChange(Object requirePasswordChange
	) {
		return findByProperty(REQUIRE_PASSWORD_CHANGE, requirePasswordChange
		);
	}
	
	public List findByLastCurrencyUom(Object lastCurrencyUom
	) {
		return findByProperty(LAST_CURRENCY_UOM, lastCurrencyUom
		);
	}
	
	public List findByLastLocale(Object lastLocale
	) {
		return findByProperty(LAST_LOCALE, lastLocale
		);
	}
	
	public List findByLastTimeZone(Object lastTimeZone
	) {
		return findByProperty(LAST_TIME_ZONE, lastTimeZone
		);
	}
	
	public List findByUserLdapDn(Object userLdapDn
	) {
		return findByProperty(USER_LDAP_DN, userLdapDn
		);
	}
	

	public List findAll() {
		log.debug("finding all UserLogin instances");
		try {
			String queryString = "from UserLogin";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserLogin merge(UserLogin detachedInstance) {
        log.debug("merging UserLogin instance");
        try {
            UserLogin result = (UserLogin) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserLogin instance) {
        log.debug("attaching dirty UserLogin instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserLogin instance) {
        log.debug("attaching clean UserLogin instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}