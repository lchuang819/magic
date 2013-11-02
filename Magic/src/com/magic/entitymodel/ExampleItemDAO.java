package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for ExampleItem entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.ExampleItem
  * @author MyEclipse Persistence Tools 
 */

public class ExampleItemDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(ExampleItemDAO.class);
	//property constants
	public static final String DESCRIPTION = "description";
	public static final String AMOUNT = "amount";
	public static final String AMOUNT_UOM_ID = "amountUomId";



    
    public void save(ExampleItem transientInstance) {
        log.debug("saving ExampleItem instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ExampleItem persistentInstance) {
        log.debug("deleting ExampleItem instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ExampleItem findById( com.magic.entitymodel.ExampleItemId id) {
        log.debug("getting ExampleItem instance with id: " + id);
        try {
            ExampleItem instance = (ExampleItem) getSession()
                    .get("com.magic.entitymodel.ExampleItem", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ExampleItem instance) {
        log.debug("finding ExampleItem instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.ExampleItem")
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
      log.debug("finding ExampleItem instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ExampleItem as model where model." 
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
	
	public List findByAmount(Object amount
	) {
		return findByProperty(AMOUNT, amount
		);
	}
	
	public List findByAmountUomId(Object amountUomId
	) {
		return findByProperty(AMOUNT_UOM_ID, amountUomId
		);
	}
	

	public List findAll() {
		log.debug("finding all ExampleItem instances");
		try {
			String queryString = "from ExampleItem";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ExampleItem merge(ExampleItem detachedInstance) {
        log.debug("merging ExampleItem instance");
        try {
            ExampleItem result = (ExampleItem) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ExampleItem instance) {
        log.debug("attaching dirty ExampleItem instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ExampleItem instance) {
        log.debug("attaching clean ExampleItem instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}