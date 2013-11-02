package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for EmailTemplateSetting entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.EmailTemplateSetting
  * @author MyEclipse Persistence Tools 
 */

public class EmailTemplateSettingDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EmailTemplateSettingDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";
	public static final String BODY_SCREEN_LOCATION = "bodyScreenLocation";
	public static final String XSLFO_ATTACH_SCREEN_LOCATION = "xslfoAttachScreenLocation";
	public static final String FROM_ADDRESS = "fromAddress";
	public static final String CC_ADDRESS = "ccAddress";
	public static final String BCC_ADDRESS = "bccAddress";
	public static final String SUBJECT = "subject";
	public static final String CONTENT_TYPE = "contentType";



    
    public void save(EmailTemplateSetting transientInstance) {
        log.debug("saving EmailTemplateSetting instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(EmailTemplateSetting persistentInstance) {
        log.debug("deleting EmailTemplateSetting instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public EmailTemplateSetting findById( java.lang.String id) {
        log.debug("getting EmailTemplateSetting instance with id: " + id);
        try {
            EmailTemplateSetting instance = (EmailTemplateSetting) getSession()
                    .get("com.magic.entitymodel.EmailTemplateSetting", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(EmailTemplateSetting instance) {
        log.debug("finding EmailTemplateSetting instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.EmailTemplateSetting")
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
      log.debug("finding EmailTemplateSetting instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from EmailTemplateSetting as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	
	public List findByBodyScreenLocation(Object bodyScreenLocation
	) {
		return findByProperty(BODY_SCREEN_LOCATION, bodyScreenLocation
		);
	}
	
	public List findByXslfoAttachScreenLocation(Object xslfoAttachScreenLocation
	) {
		return findByProperty(XSLFO_ATTACH_SCREEN_LOCATION, xslfoAttachScreenLocation
		);
	}
	
	public List findByFromAddress(Object fromAddress
	) {
		return findByProperty(FROM_ADDRESS, fromAddress
		);
	}
	
	public List findByCcAddress(Object ccAddress
	) {
		return findByProperty(CC_ADDRESS, ccAddress
		);
	}
	
	public List findByBccAddress(Object bccAddress
	) {
		return findByProperty(BCC_ADDRESS, bccAddress
		);
	}
	
	public List findBySubject(Object subject
	) {
		return findByProperty(SUBJECT, subject
		);
	}
	
	public List findByContentType(Object contentType
	) {
		return findByProperty(CONTENT_TYPE, contentType
		);
	}
	

	public List findAll() {
		log.debug("finding all EmailTemplateSetting instances");
		try {
			String queryString = "from EmailTemplateSetting";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public EmailTemplateSetting merge(EmailTemplateSetting detachedInstance) {
        log.debug("merging EmailTemplateSetting instance");
        try {
            EmailTemplateSetting result = (EmailTemplateSetting) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(EmailTemplateSetting instance) {
        log.debug("attaching dirty EmailTemplateSetting instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(EmailTemplateSetting instance) {
        log.debug("attaching clean EmailTemplateSetting instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}