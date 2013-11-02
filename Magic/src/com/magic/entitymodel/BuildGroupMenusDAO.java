package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for BuildGroupMenus entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.BuildGroupMenus
  * @author MyEclipse Persistence Tools 
 */

public class BuildGroupMenusDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(BuildGroupMenusDAO.class);
	//property constants
	public static final String MENU_NAME = "menuName";



    
    public void save(BuildGroupMenus transientInstance) {
        log.debug("saving BuildGroupMenus instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BuildGroupMenus persistentInstance) {
        log.debug("deleting BuildGroupMenus instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BuildGroupMenus findById( com.magic.entitymodel.BuildGroupMenusId id) {
        log.debug("getting BuildGroupMenus instance with id: " + id);
        try {
            BuildGroupMenus instance = (BuildGroupMenus) getSession()
                    .get("com.magic.entitymodel.BuildGroupMenus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BuildGroupMenus instance) {
        log.debug("finding BuildGroupMenus instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.BuildGroupMenus")
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
      log.debug("finding BuildGroupMenus instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BuildGroupMenus as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByMenuName(Object menuName
	) {
		return findByProperty(MENU_NAME, menuName
		);
	}
	

	public List findAll() {
		log.debug("finding all BuildGroupMenus instances");
		try {
			String queryString = "from BuildGroupMenus";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public BuildGroupMenus merge(BuildGroupMenus detachedInstance) {
        log.debug("merging BuildGroupMenus instance");
        try {
            BuildGroupMenus result = (BuildGroupMenus) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BuildGroupMenus instance) {
        log.debug("attaching dirty BuildGroupMenus instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BuildGroupMenus instance) {
        log.debug("attaching clean BuildGroupMenus instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}