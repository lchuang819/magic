package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for StatusItem entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.StatusItem
  * @author MyEclipse Persistence Tools 
 */

public class StatusItemDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(StatusItemDAO.class);
	//property constants
	public static final String STATUS_TYPE_ID = "statusTypeId";
	public static final String STATUS_CODE = "statusCode";
	public static final String SEQUENCE_ID = "sequenceId";
	public static final String DESCRIPTION = "description";



    
    public void save(StatusItem transientInstance) {
        log.debug("saving StatusItem instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(StatusItem persistentInstance) {
        log.debug("deleting StatusItem instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public StatusItem findById( java.lang.String id) {
        log.debug("getting StatusItem instance with id: " + id);
        try {
            StatusItem instance = (StatusItem) getSession()
                    .get("com.magic.entitymodel.StatusItem", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(StatusItem instance) {
        log.debug("finding StatusItem instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.StatusItem")
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
      log.debug("finding StatusItem instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StatusItem as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByStatusTypeId(Object statusTypeId
	) {
		return findByProperty(STATUS_TYPE_ID, statusTypeId
		);
	}
	
	public List findByStatusCode(Object statusCode
	) {
		return findByProperty(STATUS_CODE, statusCode
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
		log.debug("finding all StatusItem instances");
		try {
			String queryString = "from StatusItem";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public StatusItem merge(StatusItem detachedInstance) {
        log.debug("merging StatusItem instance");
        try {
            StatusItem result = (StatusItem) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(StatusItem instance) {
        log.debug("attaching dirty StatusItem instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(StatusItem instance) {
        log.debug("attaching clean StatusItem instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}