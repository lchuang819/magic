/**
 * Powered by Chuang.Liu @2011-9-27
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.entity;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apps.party.entitymodel.ContactMech;
import com.magic.constant.EntityCondition;
import com.magic.entitymodel.GenericEntity;
import com.magic.util.Debug;
import com.magic.util.SequenceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 *
 */
public class HibernateDelegator extends HibernateDaoSupport implements
		HibernateDelegatorInterface {
	
	public static final String module = HibernateDelegator.class.getName();
	
	@Autowired
	private SequenceUtil sequencer;
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findAll(java.lang.Class)
	 */
	public <T> List<T> findAll(Class<T> entityClass){
		return getHibernateTemplate().loadAll(entityClass);
	}	
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findById(java.lang.Class, com.magic.entitymodel.BaseId)
	 */
	public <T> T findById(Class<T> entityClass, java.io.Serializable id){
		
		return getHibernateTemplate().get(entityClass, id);
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findById(java.lang.Class, java.lang.String)
	 */
	public <T> T findById(Class<T> entityClass, String id){
		
		return getHibernateTemplate().get(entityClass, id);
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findById(java.lang.Class, java.lang.Integer)
	 */
	public <T> T findById(Class<T> entityClass, Integer id){
		
		return getHibernateTemplate().get(entityClass, id);
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#find(java.lang.String, java.lang.Object)
	 */
	public List find(String queryString, Object...values){
		
		return getHibernateTemplate().find(queryString, values);
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findListForPage(java.lang.Class, int, int, java.lang.String)
	 */
	public <T> List<T> findListForPage(Class<T> entityClass, int firstResult, int maxResults, String orderPropertyName, String orderDir){
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		if("ASC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.asc(orderPropertyName));
		}else if("DESC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.desc(orderPropertyName));
		}
		return getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	
	public <T> List<T> findListForPage(Class<T> entityClass, String firstResult, String maxResults, String orderPropertyName, String orderDir){
		return this.findListForPage(entityClass, Integer.parseInt(firstResult), Integer.parseInt(maxResults), orderPropertyName, orderDir);
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findListForPage(java.lang.Class, java.util.Map, int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public <T> List<T> findListForPage(Class<T> entityClass,
			Map<String, Object> allEqFields, int firstResult, int maxResults,
			String orderPropertyName, String orderDir)
			throws GenericEntityException {
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		if("ASC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.asc(orderPropertyName));
		}else if("DESC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.desc(orderPropertyName));
		}
		
		dc.add(Restrictions.allEq(allEqFields));
		
		return getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findListForPage(java.lang.Class, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findListForPage(java.lang.Class, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public <T> List<T> findListForPage(Class<T> entityClass,
			Map<String, Object> allEqFields, String firstResult,
			String maxResults, String orderPropertyName, String orderDir)
			throws GenericEntityException {
		if(UtilValidate.isEmpty(firstResult)){
			firstResult = "0";
		}
		if(UtilValidate.isEmpty(maxResults)){
			maxResults = "1";
		}
		
		return this.findListForPage(entityClass, allEqFields, Integer.parseInt(firstResult), Integer.parseInt(maxResults), orderPropertyName, orderDir);

	}

	/**
	 * 获取记录条数
	 */
	@Override
	public int getRecordCount(Class entityClass){
		final DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.setProjection(Projections.rowCount());
		
		Object o = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)throws HibernateException, SQLException{
				return (Object)dc.getExecutableCriteria(session).uniqueResult();
			}
		});
		
		return Integer.parseInt(o.toString());
		
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#saveOrUpdate(java.lang.Object)
	 */
	public boolean saveOrUpdate(GenericEntity entity){
		
		try {
			entity.setLastUpdatedStamp(new Date());
			entity.setLastUpdatedTxStamp(new Date());
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (Exception e) {
			Debug.logError(e,module);
			throw new GenericEntityException("Save entity exception", e);
		}
		
		return true;
	}
	
	private boolean save(Object entity){
		try {
			getHibernateTemplate().save(entity);
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new GenericEntityException("Save entity exception", e);
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#saveEntity(com.magic.entitymodel.GenericEntity)
	 */
	@Override
	public boolean saveEntity(GenericEntity entity) {
		try {
//			Timestamp nowDate = UtilDateTime.toTimestamp(new Date());
			Date nowDate = new Date();
			entity.setCreatedStamp(nowDate);
			entity.setCreatedTxStamp(nowDate);
			entity.setLastUpdatedStamp(nowDate);
			entity.setLastUpdatedTxStamp(nowDate);
			return this.save(entity);
		} catch (RuntimeException re) {
			Debug.logError(re, module);
			throw re;
		}
	}
	
	private boolean update(Object entity){
		try {
			getHibernateTemplate().update(entity);
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new GenericEntityException("Update entity exception", e);
		}
		
		return true;
	}
	
	public boolean updateEntity(GenericEntity entity){
		try {
			entity.setLastUpdatedStamp(new Date());
			entity.setLastUpdatedTxStamp(new Date());
			this.update(entity);
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new GenericEntityException("Update entity exception", e);
		}
		
		return true;
	}
	
	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#deleteEntity(java.lang.Object)
	 */
	public boolean deleteEntity(Object entity) throws GenericEntityException {
		getHibernateTemplate().delete(entity);
		return true;
	}
	
	public <T> T deleteById(Class<T> entityClass, java.io.Serializable id) throws GenericEntityException {
		T c = getHibernateTemplate().get(entityClass, id);
		if(c == null){
			throw new GenericEntityException("删除的对象不存在");
		}
		getHibernateTemplate().delete(c);
		return c;
	}

	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findByProperty(java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> List<T> findByProperty(Class<T> entityClass, String propertyName,
			Object value) {
		return findByCondition(entityClass, propertyName, EntityCondition.EQUALS, value);
	}

	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findByCondition(java.lang.String, java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public <T> List<T> findByCondition(Class<T> entityClass, String propertyName,
			String condition, Object value) throws GenericEntityException{
		try {
			if("like".equals(condition) && value instanceof String){
				value = "%"+value+"%";
			}
			String queryString = "from "+entityClass.getName()+" as model where model."
					+ propertyName + " " + condition + " ?";
			Debug.logInfo("findByCondition queryString:"+queryString, module);
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			Debug.logError(re, module);
			throw new GenericEntityException("查询异常", re);
		}
	}
	
	public <T> List<T> findByCondition(Class<T> entityClass, String propertyName, String condition, String value, String firstResult, String maxResults, String orderPropertyName, String orderDir){
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		if("ASC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.asc(orderPropertyName));
		}else if("DESC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.desc(orderPropertyName));
		}
		
		if(EntityCondition.LIKE.equalsIgnoreCase(condition)){
			dc.add(Restrictions.like(propertyName, value));
		}else if(EntityCondition.EQUALS.equalsIgnoreCase(condition)){
			dc.add(Restrictions.eq(propertyName, value));
		}
		
		return getHibernateTemplate().findByCriteria(dc, Integer.parseInt(firstResult), Integer.parseInt(maxResults));
	}
	
	public String saveEntityNonPk(ContactMech contactMech){
		getHibernateTemplate().save(contactMech);
		return contactMech.getContactMechId();
	}
	
	/**
	 * 
	 * @param entityClass
	 * @param fields
	 * @return
	 */
	public <T> List<T> findByCondition(Class<T> entityClass, Map fields) throws GenericEntityException{
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.add(Restrictions.allEq(fields));
		Debug.logInfo("Find "+entityClass.getName()+" by " + fields, module);
		return getHibernateTemplate().findByCriteria(dc);
	}

	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#getNextSeqId(java.lang.String)
	 */
	@Override
	public String getNextSeqId(String seqName) throws GenericEntityException {
		Debug.logInfo("Start get " + seqName + "next id.", module);
		Long seqValue = sequencer.getNextSeqId(seqName);
		if (seqValue == null) {
            // NOTE: the getNextSeqIdLong method SHOULD throw a runtime exception when no sequence value is found, which means we should never see it get here
            throw new IllegalArgumentException("Could not get next sequenced ID for sequence name: " + seqName);
        }
		Debug.logInfo("End get " + seqName + "next id.", module);
		return seqValue.toString();
	}

	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findOne(java.lang.Class, java.util.Map)
	 */
	@Override
	public <T> T findOne(Class<T> entityClass, Map fields)
			throws GenericEntityException {
		
		return this.findOne(entityClass, fields, null, null);
	}

	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findOne(java.lang.Class, java.util.Map, java.lang.String, java.lang.String)
	 */
	@Override
	public <T> T findOne(Class<T> entityClass, Map fields,
			String orderProperty, String orderDir)
			throws GenericEntityException {
		
		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.add(Restrictions.allEq(fields));
		
		if("ASC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.asc(orderProperty));
		}else if("DESC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.desc(orderProperty));
		}
		
		return (T)getHibernateTemplate().findByCriteria(dc, 1, 1).get(0);
	}

	/* (non-Javadoc)
	 * @see com.magic.entity.HibernateDelegatorInterface#findByCondition(java.lang.Class, java.util.Map, java.lang.String, java.lang.String)
	 */
	@Override
	public <T> List<T> findByCondition(Class<T> entityClass, Map fields,
			String orderProperty, String orderDir)
			throws GenericEntityException {

		DetachedCriteria dc = DetachedCriteria.forClass(entityClass);
		dc.add(Restrictions.allEq(fields));
		
		if("ASC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.asc(orderProperty));
		}else if("DESC".equalsIgnoreCase(orderDir)){
			dc.addOrder(Order.desc(orderProperty));
		}
		
		return getHibernateTemplate().findByCriteria(dc);
	}
	
}
