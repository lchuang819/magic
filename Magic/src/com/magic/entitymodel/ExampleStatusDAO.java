package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for ExampleStatus entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ExampleStatus
  * @author MyEclipse Persistence Tools 
 */

public class ExampleStatusDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ExampleStatusDAO.class);
	//property constants
	public static final String STATUS_ID = "statusId";



    
    public void save(ExampleStatus transientInstance) {
        log.debug("saving ExampleStatus instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ExampleStatus persistentInstance) {
        log.debug("deleting ExampleStatus instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ExampleStatus findById( com.magic.entitymodel.ExampleStatusId id) {
        log.debug("getting ExampleStatus instance with id: " + id);
        try {
            ExampleStatus instance = (ExampleStatus) getSession()
                    .get("com.magic.entitymodel.ExampleStatus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ExampleStatus instance) {
        log.debug("finding ExampleStatus instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ExampleStatus")
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
      log.debug("finding ExampleStatus instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ExampleStatus as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByStatusId(Object statusId
	) {
		return findByProperty(STATUS_ID, statusId
		);
	}
	

	public List findAll() {
		log.debug("finding all ExampleStatus instances");
		try {
			String queryString = "from ExampleStatus";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ExampleStatus merge(ExampleStatus detachedInstance) {
        log.debug("merging ExampleStatus instance");
        try {
            ExampleStatus result = (ExampleStatus) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ExampleStatus instance) {
        log.debug("attaching dirty ExampleStatus instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ExampleStatus instance) {
        log.debug("attaching clean ExampleStatus instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}