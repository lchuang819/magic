package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for DataSource entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.DataSource
  * @author MyEclipse Persistence Tools 
 */

public class DataSourceDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(DataSourceDAO.class);
	//property constants
	public static final String DATA_SOURCE_TYPE_ID = "dataSourceTypeId";
	public static final String DESCRIPTION = "description";



    
    public void save(DataSource transientInstance) {
        log.debug("saving DataSource instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(DataSource persistentInstance) {
        log.debug("deleting DataSource instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public DataSource findById( java.lang.String id) {
        log.debug("getting DataSource instance with id: " + id);
        try {
            DataSource instance = (DataSource) getSession()
                    .get("com.magic.entitymodel.DataSource", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(DataSource instance) {
        log.debug("finding DataSource instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.DataSource")
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
      log.debug("finding DataSource instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from DataSource as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDataSourceTypeId(Object dataSourceTypeId
	) {
		return findByProperty(DATA_SOURCE_TYPE_ID, dataSourceTypeId
		);
	}
	
	public List findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all DataSource instances");
		try {
			String queryString = "from DataSource";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public DataSource merge(DataSource detachedInstance) {
        log.debug("merging DataSource instance");
        try {
            DataSource result = (DataSource) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(DataSource instance) {
        log.debug("attaching dirty DataSource instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(DataSource instance) {
        log.debug("attaching clean DataSource instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}