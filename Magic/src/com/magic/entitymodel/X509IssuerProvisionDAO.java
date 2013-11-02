package com.magic.entitymodel;

import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for X509IssuerProvision entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.X509IssuerProvision
  * @author MyEclipse Persistence Tools 
 */

public class X509IssuerProvisionDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(X509IssuerProvisionDAO.class);
	//property constants
	public static final String COMMON_NAME = "commonName";
	public static final String ORGANIZATIONAL_UNIT = "organizationalUnit";
	public static final String ORGANIZATION_NAME = "organizationName";
	public static final String CITY_LOCALITY = "cityLocality";
	public static final String STATE_PROVINCE = "stateProvince";
	public static final String COUNTRY = "country";
	public static final String SERIAL_NUMBER = "serialNumber";



    
    public void save(X509IssuerProvision transientInstance) {
        log.debug("saving X509IssuerProvision instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(X509IssuerProvision persistentInstance) {
        log.debug("deleting X509IssuerProvision instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public X509IssuerProvision findById( java.lang.String id) {
        log.debug("getting X509IssuerProvision instance with id: " + id);
        try {
            X509IssuerProvision instance = (X509IssuerProvision) getSession()
                    .get("com.magic.entitymodel.X509IssuerProvision", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(X509IssuerProvision instance) {
        log.debug("finding X509IssuerProvision instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.X509IssuerProvision")
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
      log.debug("finding X509IssuerProvision instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from X509IssuerProvision as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByCommonName(Object commonName
	) {
		return findByProperty(COMMON_NAME, commonName
		);
	}
	
	public List findByOrganizationalUnit(Object organizationalUnit
	) {
		return findByProperty(ORGANIZATIONAL_UNIT, organizationalUnit
		);
	}
	
	public List findByOrganizationName(Object organizationName
	) {
		return findByProperty(ORGANIZATION_NAME, organizationName
		);
	}
	
	public List findByCityLocality(Object cityLocality
	) {
		return findByProperty(CITY_LOCALITY, cityLocality
		);
	}
	
	public List findByStateProvince(Object stateProvince
	) {
		return findByProperty(STATE_PROVINCE, stateProvince
		);
	}
	
	public List findByCountry(Object country
	) {
		return findByProperty(COUNTRY, country
		);
	}
	
	public List findBySerialNumber(Object serialNumber
	) {
		return findByProperty(SERIAL_NUMBER, serialNumber
		);
	}
	

	public List findAll() {
		log.debug("finding all X509IssuerProvision instances");
		try {
			String queryString = "from X509IssuerProvision";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public X509IssuerProvision merge(X509IssuerProvision detachedInstance) {
        log.debug("merging X509IssuerProvision instance");
        try {
            X509IssuerProvision result = (X509IssuerProvision) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(X509IssuerProvision instance) {
        log.debug("attaching dirty X509IssuerProvision instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(X509IssuerProvision instance) {
        log.debug("attaching clean X509IssuerProvision instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}