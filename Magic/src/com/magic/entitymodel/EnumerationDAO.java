package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for Enumeration entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.Enumeration
  * @author MyEclipse Persistence Tools 
 */

public class EnumerationDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(EnumerationDAO.class);
	//property constants
	public static final String ENUM_TYPE_ID = "enumTypeId";
	public static final String ENUM_CODE = "enumCode";
	public static final String SEQUENCE_ID = "sequenceId";
	public static final String DESCRIPTION = "description";



    
    public void save(Enumeration transientInstance) {
        log.debug("saving Enumeration instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Enumeration persistentInstance) {
        log.debug("deleting Enumeration instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Enumeration findById( java.lang.String id) {
        log.debug("getting Enumeration instance with id: " + id);
        try {
            Enumeration instance = (Enumeration) getSession()
                    .get("com.magic.entitymodel.Enumeration", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Enumeration instance) {
        log.debug("finding Enumeration instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.Enumeration")
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
      log.debug("finding Enumeration instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Enumeration as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByEnumTypeId(Object enumTypeId
	) {
		return findByProperty(ENUM_TYPE_ID, enumTypeId
		);
	}
	
	public List findByEnumCode(Object enumCode
	) {
		return findByProperty(ENUM_CODE, enumCode
		);
	}
	
	public List findBySequenceId(Object sequenceId
	) {
		return findByProperty(SEQUENCE_ID, sequenceId
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all Enumeration instances");
		try {
			String queryString = "from Enumeration";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Enumeration merge(Enumeration detachedInstance) {
        log.debug("merging Enumeration instance");
        try {
            Enumeration result = (Enumeration) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Enumeration instance) {
        log.debug("attaching dirty Enumeration instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Enumeration instance) {
        log.debug("attaching clean Enumeration instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}