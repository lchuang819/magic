package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for TestingNodeMember entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.TestingNodeMember
  * @author MyEclipse Persistence Tools 
 */

public class TestingNodeMemberDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(TestingNodeMemberDAO.class);
	//property constants



    
    public void save(TestingNodeMember transientInstance) {
        log.debug("saving TestingNodeMember instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(TestingNodeMember persistentInstance) {
        log.debug("deleting TestingNodeMember instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public TestingNodeMember findById( com.magic.entitymodel.TestingNodeMemberId id) {
        log.debug("getting TestingNodeMember instance with id: " + id);
        try {
            TestingNodeMember instance = (TestingNodeMember) getSession()
                    .get("com.magic.entitymodel.TestingNodeMember", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(TestingNodeMember instance) {
        log.debug("finding TestingNodeMember instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.TestingNodeMember")
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
      log.debug("finding TestingNodeMember instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from TestingNodeMember as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all TestingNodeMember instances");
		try {
			String queryString = "from TestingNodeMember";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public TestingNodeMember merge(TestingNodeMember detachedInstance) {
        log.debug("merging TestingNodeMember instance");
        try {
            TestingNodeMember result = (TestingNodeMember) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(TestingNodeMember instance) {
        log.debug("attaching dirty TestingNodeMember instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(TestingNodeMember instance) {
        log.debug("attaching clean TestingNodeMember instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}