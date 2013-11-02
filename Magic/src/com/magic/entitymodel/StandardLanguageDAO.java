package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for StandardLanguage entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.StandardLanguage
  * @author MyEclipse Persistence Tools 
 */

public class StandardLanguageDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(StandardLanguageDAO.class);
	//property constants
	public static final String LANG_CODE3T = "langCode3t";
	public static final String LANG_CODE3B = "langCode3b";
	public static final String LANG_CODE2 = "langCode2";
	public static final String LANG_NAME = "langName";
	public static final String LANG_FAMILY = "langFamily";
	public static final String LANG_CHARSET = "langCharset";



    
    public void save(StandardLanguage transientInstance) {
        log.debug("saving StandardLanguage instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(StandardLanguage persistentInstance) {
        log.debug("deleting StandardLanguage instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public StandardLanguage findById( java.lang.String id) {
        log.debug("getting StandardLanguage instance with id: " + id);
        try {
            StandardLanguage instance = (StandardLanguage) getSession()
                    .get("com.magic.entitymodel.StandardLanguage", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(StandardLanguage instance) {
        log.debug("finding StandardLanguage instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.StandardLanguage")
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
      log.debug("finding StandardLanguage instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StandardLanguage as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByLangCode3t(Object langCode3t
	) {
		return findByProperty(LANG_CODE3T, langCode3t
		);
	}
	
	public List findByLangCode3b(Object langCode3b
	) {
		return findByProperty(LANG_CODE3B, langCode3b
		);
	}
	
	public List findByLangCode2(Object langCode2
	) {
		return findByProperty(LANG_CODE2, langCode2
		);
	}
	
	public List findByLangName(Object langName
	) {
		return findByProperty(LANG_NAME, langName
		);
	}
	
	public List findByLangFamily(Object langFamily
	) {
		return findByProperty(LANG_FAMILY, langFamily
		);
	}
	
	public List findByLangCharset(Object langCharset
	) {
		return findByProperty(LANG_CHARSET, langCharset
		);
	}
	

	public List findAll() {
		log.debug("finding all StandardLanguage instances");
		try {
			String queryString = "from StandardLanguage";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public StandardLanguage merge(StandardLanguage detachedInstance) {
        log.debug("merging StandardLanguage instance");
        try {
            StandardLanguage result = (StandardLanguage) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(StandardLanguage instance) {
        log.debug("attaching dirty StandardLanguage instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(StandardLanguage instance) {
        log.debug("attaching clean StandardLanguage instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}