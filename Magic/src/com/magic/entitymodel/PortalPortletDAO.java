package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for PortalPortlet entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PortalPortlet
  * @author MyEclipse Persistence Tools 
 */

public class PortalPortletDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PortalPortletDAO.class);
	//property constants
	public static final String PORTLET_NAME = "portletName";
	public static final String SCREEN_NAME = "screenName";
	public static final String SCREEN_LOCATION = "screenLocation";
	public static final String EDIT_FORM_NAME = "editFormName";
	public static final String EDIT_FORM_LOCATION = "editFormLocation";
	public static final String DESCRIPTION = "description";
	public static final String SCREENSHOT = "screenshot";
	public static final String SECURITY_SERVICE_NAME = "securityServiceName";
	public static final String SECURITY_MAIN_ACTION = "securityMainAction";



    
    public void save(PortalPortlet transientInstance) {
        log.debug("saving PortalPortlet instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PortalPortlet persistentInstance) {
        log.debug("deleting PortalPortlet instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PortalPortlet findById( java.lang.String id) {
        log.debug("getting PortalPortlet instance with id: " + id);
        try {
            PortalPortlet instance = (PortalPortlet) getSession()
                    .get("com.magic.entitymodel.PortalPortlet", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PortalPortlet instance) {
        log.debug("finding PortalPortlet instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PortalPortlet")
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
      log.debug("finding PortalPortlet instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PortalPortlet as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPortletName(Object portletName
	) {
		return findByProperty(PORTLET_NAME, portletName
		);
	}
	
	public List findByScreenName(Object screenName
	) {
		return findByProperty(SCREEN_NAME, screenName
		);
	}
	
	public List findByScreenLocation(Object screenLocation
	) {
		return findByProperty(SCREEN_LOCATION, screenLocation
		);
	}
	
	public List findByEditFormName(Object editFormName
	) {
		return findByProperty(EDIT_FORM_NAME, editFormName
		);
	}
	
	public List findByEditFormLocation(Object editFormLocation
	) {
		return findByProperty(EDIT_FORM_LOCATION, editFormLocation
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	
	public List findByScreenshot(Object screenshot
	) {
		return findByProperty(SCREENSHOT, screenshot
		);
	}
	
	public List findBySecurityServiceName(Object securityServiceName
	) {
		return findByProperty(SECURITY_SERVICE_NAME, securityServiceName
		);
	}
	
	public List findBySecurityMainAction(Object securityMainAction
	) {
		return findByProperty(SECURITY_MAIN_ACTION, securityMainAction
		);
	}
	

	public List findAll() {
		log.debug("finding all PortalPortlet instances");
		try {
			String queryString = "from PortalPortlet";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PortalPortlet merge(PortalPortlet detachedInstance) {
        log.debug("merging PortalPortlet instance");
        try {
            PortalPortlet result = (PortalPortlet) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PortalPortlet instance) {
        log.debug("attaching dirty PortalPortlet instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PortalPortlet instance) {
        log.debug("attaching clean PortalPortlet instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}