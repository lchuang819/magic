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
 	* A data access object (DAO) providing persistence and search support for PortalPage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.PortalPage
  * @author MyEclipse Persistence Tools 
 */

public class PortalPageDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(PortalPageDAO.class);
	//property constants
	public static final String PORTAL_PAGE_NAME = "portalPageName";
	public static final String DESCRIPTION = "description";
	public static final String OWNER_USER_LOGIN_ID = "ownerUserLoginId";
	public static final String ORIGINAL_PORTAL_PAGE_ID = "originalPortalPageId";
	public static final String PARENT_PORTAL_PAGE_ID = "parentPortalPageId";
	public static final String SECURITY_GROUP_ID = "securityGroupId";



    
    public void save(PortalPage transientInstance) {
        log.debug("saving PortalPage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PortalPage persistentInstance) {
        log.debug("deleting PortalPage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PortalPage findById( java.lang.String id) {
        log.debug("getting PortalPage instance with id: " + id);
        try {
            PortalPage instance = (PortalPage) getSession()
                    .get("com.magic.entitymodel.PortalPage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(PortalPage instance) {
        log.debug("finding PortalPage instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.PortalPage")
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
      log.debug("finding PortalPage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PortalPage as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByPortalPageName(Object portalPageName
	) {
		return findByProperty(PORTAL_PAGE_NAME, portalPageName
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	
	public List findByOwnerUserLoginId(Object ownerUserLoginId
	) {
		return findByProperty(OWNER_USER_LOGIN_ID, ownerUserLoginId
		);
	}
	
	public List findByOriginalPortalPageId(Object originalPortalPageId
	) {
		return findByProperty(ORIGINAL_PORTAL_PAGE_ID, originalPortalPageId
		);
	}
	
	public List findByParentPortalPageId(Object parentPortalPageId
	) {
		return findByProperty(PARENT_PORTAL_PAGE_ID, parentPortalPageId
		);
	}
	
	public List findBySecurityGroupId(Object securityGroupId
	) {
		return findByProperty(SECURITY_GROUP_ID, securityGroupId
		);
	}
	

	public List findAll() {
		log.debug("finding all PortalPage instances");
		try {
			String queryString = "from PortalPage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PortalPage merge(PortalPage detachedInstance) {
        log.debug("merging PortalPage instance");
        try {
            PortalPage result = (PortalPage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PortalPage instance) {
        log.debug("attaching dirty PortalPage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PortalPage instance) {
        log.debug("attaching clean PortalPage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}