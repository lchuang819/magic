package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;

/**
 	* A data access object (DAO) providing persistence and search support for Example entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.Example
  * @author MyEclipse Persistence Tools 
 */

public class ExampleDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ExampleDAO.class);
	//property constants
	public static final String EXAMPLE_TYPE_ID = "exampleTypeId";
	public static final String STATUS_ID = "statusId";
	public static final String EXAMPLE_NAME = "exampleName";
	public static final String DESCRIPTION = "description";
	public static final String LONG_DESCRIPTION = "longDescription";
	public static final String COMMENTS = "comments";
	public static final String ANOTHER_TEXT = "anotherText";



    
    public void save(Example transientInstance) {
        log.debug("saving Example instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Example persistentInstance) {
        log.debug("deleting Example instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Example findById( java.lang.String id) {
        log.debug("getting Example instance with id: " + id);
        try {
            Example instance = (Example) getSession()
                    .get("com.magic.entitymodel.Example", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Example instance) {
        log.debug("finding Example instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.Example")
                    .add(org.hibernate.criterion.Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Example instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Example as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByExampleTypeId(Object exampleTypeId
	) {
		return findByProperty(EXAMPLE_TYPE_ID, exampleTypeId
		);
	}
	
	public List findByStatusId(Object statusId
	) {
		return findByProperty(STATUS_ID, statusId
		);
	}
	
	public List findByExampleName(Object exampleName
	) {
		return findByProperty(EXAMPLE_NAME, exampleName
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	
	public List findByLongDescription(Object longDescription
	) {
		return findByProperty(LONG_DESCRIPTION, longDescription
		);
	}
	
	public List findByComments(Object comments
	) {
		return findByProperty(COMMENTS, comments
		);
	}
	
	public List findByAnotherText(Object anotherText
	) {
		return findByProperty(ANOTHER_TEXT, anotherText
		);
	}
	

	public List findAll() {
		log.debug("finding all Example instances");
		try {
			String queryString = "from Example";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Example merge(Example detachedInstance) {
        log.debug("merging Example instance");
        try {
            Example result = (Example) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Example instance) {
        log.debug("attaching dirty Example instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Example instance) {
        log.debug("attaching clean Example instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}