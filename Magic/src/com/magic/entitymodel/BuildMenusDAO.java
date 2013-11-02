package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for BuildMenus entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.BuildMenus
  * @author MyEclipse Persistence Tools 
 */

public class BuildMenusDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(BuildMenusDAO.class);
	//property constants
	public static final String PARENT_ID = "parentId";
	public static final String MENU_NAME = "menuName";
	public static final String ICON_CLS = "iconCls";
	public static final String ISROOT = "isroot";
	public static final String ENABLE = "enable";
	public static final String SEQUENCE_ID = "sequenceId";
	public static final String CONTENT_PATH = "contentPath";



    
    public void save(BuildMenus transientInstance) {
        log.debug("saving BuildMenus instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(BuildMenus persistentInstance) {
        log.debug("deleting BuildMenus instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public BuildMenus findById( java.lang.String id) {
        log.debug("getting BuildMenus instance with id: " + id);
        try {
            BuildMenus instance = (BuildMenus) getSession()
                    .get("com.magic.entitymodel.BuildMenus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(BuildMenus instance) {
        log.debug("finding BuildMenus instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.BuildMenus")
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
      log.debug("finding BuildMenus instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from BuildMenus as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByParentId(Object parentId
	) {
		return findByProperty(PARENT_ID, parentId
		);
	}
	
	public List findByMenuName(Object menuName
	) {
		return findByProperty(MENU_NAME, menuName
		);
	}
	
	public List findByIconCls(Object iconCls
	) {
		return findByProperty(ICON_CLS, iconCls
		);
	}
	
	public List findByIsroot(Object isroot
	) {
		return findByProperty(ISROOT, isroot
		);
	}
	
	public List findByEnable(Object enable
	) {
		return findByProperty(ENABLE, enable
		);
	}
	
	public List findBySequenceId(Object sequenceId
	) {
		return findByProperty(SEQUENCE_ID, sequenceId
		);
	}
	
	public List findByContentPath(Object contentPath
	) {
		return findByProperty(CONTENT_PATH, contentPath
		);
	}
	

	public List findAll() {
		log.debug("finding all BuildMenus instances");
		try {
			String queryString = "from BuildMenus";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public BuildMenus merge(BuildMenus detachedInstance) {
        log.debug("merging BuildMenus instance");
        try {
            BuildMenus result = (BuildMenus) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BuildMenus instance) {
        log.debug("attaching dirty BuildMenus instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(BuildMenus instance) {
        log.debug("attaching clean BuildMenus instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}