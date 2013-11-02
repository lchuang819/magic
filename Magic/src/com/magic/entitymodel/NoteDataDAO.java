package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for NoteData entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.NoteData
  * @author MyEclipse Persistence Tools 
 */

public class NoteDataDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(NoteDataDAO.class);
	//property constants
	public static final String NOTE_NAME = "noteName";
	public static final String NOTE_INFO = "noteInfo";



    
    public void save(NoteData transientInstance) {
        log.debug("saving NoteData instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(NoteData persistentInstance) {
        log.debug("deleting NoteData instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public NoteData findById( java.lang.String id) {
        log.debug("getting NoteData instance with id: " + id);
        try {
            NoteData instance = (NoteData) getSession()
                    .get("com.magic.entitymodel.NoteData", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(NoteData instance) {
        log.debug("finding NoteData instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.NoteData")
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
      log.debug("finding NoteData instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from NoteData as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByNoteName(Object noteName
	) {
		return findByProperty(NOTE_NAME, noteName
		);
	}
	
	public List findByNoteInfo(Object noteInfo
	) {
		return findByProperty(NOTE_INFO, noteInfo
		);
	}
	

	public List findAll() {
		log.debug("finding all NoteData instances");
		try {
			String queryString = "from NoteData";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public NoteData merge(NoteData detachedInstance) {
        log.debug("merging NoteData instance");
        try {
            NoteData result = (NoteData) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(NoteData instance) {
        log.debug("attaching dirty NoteData instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(NoteData instance) {
        log.debug("attaching clean NoteData instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}