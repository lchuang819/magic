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
 	* A data access object (DAO) providing persistence and search support for Testing entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.Testing
  * @author MyEclipse Persistence Tools 
 */

public class TestingDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(TestingDAO.class);
	//property constants
	public static final String TESTING_TYPE_ID = "testingTypeId";
	public static final String TESTING_NAME = "testingName";
	public static final String DESCRIPTION = "description";
	public static final String COMMENTS = "comments";



    
    public void save(Testing transientInstance) {
        log.debug("saving Testing instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Testing persistentInstance) {
        log.debug("deleting Testing instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Testing findById( java.lang.String id) {
        log.debug("getting Testing instance with id: " + id);
        try {
            Testing instance = (Testing) getSession()
                    .get("com.magic.entitymodel.Testing", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Testing instance) {
        log.debug("finding Testing instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.Testing")
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
      log.debug("finding Testing instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Testing as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTestingTypeId(Object testingTypeId
	) {
		return findByProperty(TESTING_TYPE_ID, testingTypeId
		);
	}
	
	public List findByTestingName(Object testingName
	) {
		return findByProperty(TESTING_NAME, testingName
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	
	public List findByComments(Object comments
	) {
		return findByProperty(COMMENTS, comments
		);
	}
	

	public List findAll() {
		log.debug("finding all Testing instances");
		try {
			String queryString = "from Testing";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Testing merge(Testing detachedInstance) {
        log.debug("merging Testing instance");
        try {
            Testing result = (Testing) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Testing instance) {
        log.debug("attaching dirty Testing instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Testing instance) {
        log.debug("attaching clean Testing instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}