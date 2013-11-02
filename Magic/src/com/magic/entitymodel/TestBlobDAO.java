package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for TestBlob entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.TestBlob
  * @author MyEclipse Persistence Tools 
 */

public class TestBlobDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(TestBlobDAO.class);
	//property constants
	public static final String TEST_BLOB_FIELD = "testBlobField";



    
    public void save(TestBlob transientInstance) {
        log.debug("saving TestBlob instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TestBlob persistentInstance) {
        log.debug("deleting TestBlob instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TestBlob findById( java.lang.String id) {
        log.debug("getting TestBlob instance with id: " + id);
        try {
            TestBlob instance = (TestBlob) getSession()
                    .get("com.magic.entitymodel.TestBlob", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TestBlob instance) {
        log.debug("finding TestBlob instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.TestBlob")
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
      log.debug("finding TestBlob instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TestBlob as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByTestBlobField(Object testBlobField
	) {
		return findByProperty(TEST_BLOB_FIELD, testBlobField
		);
	}
	

	public List findAll() {
		log.debug("finding all TestBlob instances");
		try {
			String queryString = "from TestBlob";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TestBlob merge(TestBlob detachedInstance) {
        log.debug("merging TestBlob instance");
        try {
            TestBlob result = (TestBlob) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TestBlob instance) {
        log.debug("attaching dirty TestBlob instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TestBlob instance) {
        log.debug("attaching clean TestBlob instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}