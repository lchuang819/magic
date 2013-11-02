package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for KeywordThesaurus entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.KeywordThesaurus
  * @author MyEclipse Persistence Tools 
 */

public class KeywordThesaurusDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(KeywordThesaurusDAO.class);
	//property constants
	public static final String RELATIONSHIP_ENUM_ID = "relationshipEnumId";



    
    public void save(KeywordThesaurus transientInstance) {
        log.debug("saving KeywordThesaurus instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(KeywordThesaurus persistentInstance) {
        log.debug("deleting KeywordThesaurus instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public KeywordThesaurus findById( com.magic.entitymodel.KeywordThesaurusId id) {
        log.debug("getting KeywordThesaurus instance with id: " + id);
        try {
            KeywordThesaurus instance = (KeywordThesaurus) getSession()
                    .get("com.magic.entitymodel.KeywordThesaurus", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(KeywordThesaurus instance) {
        log.debug("finding KeywordThesaurus instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.KeywordThesaurus")
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
      log.debug("finding KeywordThesaurus instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from KeywordThesaurus as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByRelationshipEnumId(Object relationshipEnumId
	) {
		return findByProperty(RELATIONSHIP_ENUM_ID, relationshipEnumId
		);
	}
	

	public List findAll() {
		log.debug("finding all KeywordThesaurus instances");
		try {
			String queryString = "from KeywordThesaurus";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public KeywordThesaurus merge(KeywordThesaurus detachedInstance) {
        log.debug("merging KeywordThesaurus instance");
        try {
            KeywordThesaurus result = (KeywordThesaurus) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(KeywordThesaurus instance) {
        log.debug("attaching dirty KeywordThesaurus instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(KeywordThesaurus instance) {
        log.debug("attaching clean KeywordThesaurus instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}