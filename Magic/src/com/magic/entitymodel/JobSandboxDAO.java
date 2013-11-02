package com.magic.entitymodel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 	* A data access object (DAO) providing persistence and search support for JobSandbox entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.magic.entitymodel.JobSandbox
  * @author MyEclipse Persistence Tools 
 */

public class JobSandboxDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(JobSandboxDAO.class);
	//property constants
	public static final String JOB_NAME = "jobName";
	public static final String POOL_ID = "poolId";
	public static final String STATUS_ID = "statusId";
	public static final String PARENT_JOB_ID = "parentJobId";
	public static final String PREVIOUS_JOB_ID = "previousJobId";
	public static final String SERVICE_NAME = "serviceName";
	public static final String LOADER_NAME = "loaderName";
	public static final String AUTH_USER_LOGIN_ID = "authUserLoginId";
	public static final String RUN_AS_USER = "runAsUser";
	public static final String RUNTIME_DATA_ID = "runtimeDataId";
	public static final String RECURRENCE_INFO_ID = "recurrenceInfoId";
	public static final String TEMP_EXPR_ID = "tempExprId";
	public static final String RUN_BY_INSTANCE_ID = "runByInstanceId";



    
    public void save(JobSandbox transientInstance) {
        log.debug("saving JobSandbox instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(JobSandbox persistentInstance) {
        log.debug("deleting JobSandbox instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public JobSandbox findById( java.lang.String id) {
        log.debug("getting JobSandbox instance with id: " + id);
        try {
            JobSandbox instance = (JobSandbox) getSession()
                    .get("com.magic.entitymodel.JobSandbox", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(JobSandbox instance) {
        log.debug("finding JobSandbox instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.magic.entitymodel.JobSandbox")
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
      log.debug("finding JobSandbox instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from JobSandbox as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByJobName(Object jobName
	) {
		return findByProperty(JOB_NAME, jobName
		);
	}
	
	public List findByPoolId(Object poolId
	) {
		return findByProperty(POOL_ID, poolId
		);
	}
	
	public List findByStatusId(Object statusId
	) {
		return findByProperty(STATUS_ID, statusId
		);
	}
	
	public List findByParentJobId(Object parentJobId
	) {
		return findByProperty(PARENT_JOB_ID, parentJobId
		);
	}
	
	public List findByPreviousJobId(Object previousJobId
	) {
		return findByProperty(PREVIOUS_JOB_ID, previousJobId
		);
	}
	
	public List findByServiceName(Object serviceName
	) {
		return findByProperty(SERVICE_NAME, serviceName
		);
	}
	
	public List findByLoaderName(Object loaderName
	) {
		return findByProperty(LOADER_NAME, loaderName
		);
	}
	
	public List findByAuthUserLoginId(Object authUserLoginId
	) {
		return findByProperty(AUTH_USER_LOGIN_ID, authUserLoginId
		);
	}
	
	public List findByRunAsUser(Object runAsUser
	) {
		return findByProperty(RUN_AS_USER, runAsUser
		);
	}
	
	public List findByRuntimeDataId(Object runtimeDataId
	) {
		return findByProperty(RUNTIME_DATA_ID, runtimeDataId
		);
	}
	
	public List findByRecurrenceInfoId(Object recurrenceInfoId
	) {
		return findByProperty(RECURRENCE_INFO_ID, recurrenceInfoId
		);
	}
	
	public List findByTempExprId(Object tempExprId
	) {
		return findByProperty(TEMP_EXPR_ID, tempExprId
		);
	}
	
	public List findByRunByInstanceId(Object runByInstanceId
	) {
		return findByProperty(RUN_BY_INSTANCE_ID, runByInstanceId
		);
	}
	

	public List findAll() {
		log.debug("finding all JobSandbox instances");
		try {
			String queryString = "from JobSandbox";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public JobSandbox merge(JobSandbox detachedInstance) {
        log.debug("merging JobSandbox instance");
        try {
            JobSandbox result = (JobSandbox) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(JobSandbox instance) {
        log.debug("attaching dirty JobSandbox instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(JobSandbox instance) {
        log.debug("attaching clean JobSandbox instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}