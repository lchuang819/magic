package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for BuildCodeBank entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.BuildCodeBank
  * @author MyEclipse Persistence Tools 
 */

public class BuildCodeBankDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(BuildCodeBankDAO.class);
	//property constants
	public static final String CODE_EXT_VALUE = "codeExtValue";
	public static final String CODE_OTH_VALUE = "codeOthValue";
	public static final String CODE_SHORT_DESCRIPTION = "codeShortDescription";
	public static final String CODE_LONG_DESCRIPTION = "codeLongDescription";
	public static final String LANG_CODE = "langCode";
	public static final String CREATE_BY = "createBy";
	public static final String LAST_UPDATE_BY = "lastUpdateBy";



    
    public void save(BuildCodeBank transientInstance) {
        log.debug("saving BuildCodeBank instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BuildCodeBank persistentInstance) {
        log.debug("deleting BuildCodeBank instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BuildCodeBank findById( com.magic.entitymodel.BuildCodeBankId id) {
        log.debug("getting BuildCodeBank instance with id: " + id);
        try {
            BuildCodeBank instance = (BuildCodeBank) getSession()
                    .get("com.magic.entitymodel.BuildCodeBank", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BuildCodeBank instance) {
        log.debug("finding BuildCodeBank instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.BuildCodeBank")
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
      log.debug("finding BuildCodeBank instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BuildCodeBank as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCodeExtValue(Object codeExtValue
	) {
		return findByProperty(CODE_EXT_VALUE, codeExtValue
		);
	}
	
	public List findByCodeOthValue(Object codeOthValue
	) {
		return findByProperty(CODE_OTH_VALUE, codeOthValue
		);
	}
	
	public List findByCodeShortDescription(Object codeShortDescription
	) {
		return findByProperty(CODE_SHORT_DESCRIPTION, codeShortDescription
		);
	}
	
	public List findByCodeLongDescription(Object codeLongDescription
	) {
		return findByProperty(CODE_LONG_DESCRIPTION, codeLongDescription
		);
	}
	
	public List findByLangCode(Object langCode
	) {
		return findByProperty(LANG_CODE, langCode
		);
	}
	
	public List findByCreateBy(Object createBy
	) {
		return findByProperty(CREATE_BY, createBy
		);
	}
	
	public List findByLastUpdateBy(Object lastUpdateBy
	) {
		return findByProperty(LAST_UPDATE_BY, lastUpdateBy
		);
	}
	

	public List findAll() {
		log.debug("finding all BuildCodeBank instances");
		try {
			String queryString = "from BuildCodeBank";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public BuildCodeBank merge(BuildCodeBank detachedInstance) {
        log.debug("merging BuildCodeBank instance");
        try {
            BuildCodeBank result = (BuildCodeBank) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BuildCodeBank instance) {
        log.debug("attaching dirty BuildCodeBank instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BuildCodeBank instance) {
        log.debug("attaching clean BuildCodeBank instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}