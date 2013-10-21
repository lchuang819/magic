/**
 * Powered by Chuang.Liu @2011-10-9
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.entity;

import java.util.List;
import java.util.Map;

import com.apps.party.entitymodel.ContactMech;
import com.magic.entitymodel.GenericEntity;

/**
 * @author lchuang
 * @2011-10-9
 */
public interface HibernateDelegatorInterface {

	/**
	 * by entityClass find all entity data
	 * @param entityClass
	 * @return
	 */
	public abstract <T> List<T> findAll(Class<T> entityClass)throws GenericEntityException;

	public abstract <T> T findById(Class<T> entityClass, java.io.Serializable id)throws GenericEntityException;

	public abstract <T> T findById(Class<T> entityClass, String id)throws GenericEntityException;

	public abstract <T> T findById(Class<T> entityClass, Integer id)throws GenericEntityException;

	public abstract <T> T findOne(Class<T> entityClass, Map fields)throws GenericEntityException;
	
	public abstract <T> T findOne(Class<T> entityClass, Map fields, String orderPropertyName, String orderDir)throws GenericEntityException;
	
	public abstract List find(String queryString, Object... values)throws GenericEntityException;

	public abstract <T> List<T> findListForPage(Class<T> entityClass, int firstResult,
			int maxResults, String orderPropertyName, String orderDir)throws GenericEntityException;
	
	public abstract <T> List<T> findListForPage(Class<T> entityClass, String firstResult,
			String maxResults, String orderPropertyName, String orderDir)throws GenericEntityException;
	
	public abstract <T> List<T> findListForPage(Class<T> entityClass, Map<String, Object> allEqFields, int firstResult,
			int maxResults, String orderPropertyName, String orderDir)throws GenericEntityException;
	
	public abstract <T> List<T> findListForPage(Class<T> entityClass, Map<String, Object> allEqFields, String firstResult,
			String maxResults, String orderPropertyName, String orderDir)throws GenericEntityException;

	public abstract int getRecordCount(Class entityClass)throws GenericEntityException;

	public abstract boolean saveOrUpdate(GenericEntity entity)throws GenericEntityException;
	
	public abstract boolean updateEntity(GenericEntity entity)throws GenericEntityException;
	
	public abstract boolean saveEntity(GenericEntity entity)throws GenericEntityException;

	public abstract boolean deleteEntity(Object entity)throws GenericEntityException;
	
	public abstract <T> T deleteById(Class<T> entityClass, java.io.Serializable id) throws GenericEntityException;
	
	public abstract <T> List<T> findByProperty(Class<T> entityClass, String propertyName, Object value)throws GenericEntityException;
	
	public abstract <T>List <T> findByCondition(Class<T> entityClass, String propertyName, String condition, Object value)throws GenericEntityException;

	public abstract <T> List<T> findByCondition(Class<T> entityClass, String propertyName, String condition, String value, String firstResult, String maxResults, String orderPropertyName, String orderDir)throws GenericEntityException;
	
	public abstract <T> List<T>  findByCondition(Class<T> entityClass, Map fields)throws GenericEntityException;
	
	public abstract <T> List<T>  findByCondition(Class<T> entityClass, Map fields, String orderProperty, String orderDir)throws GenericEntityException;
	
	public abstract String saveEntityNonPk(ContactMech contactMech)throws GenericEntityException;
	
	public abstract String getNextSeqId(String seqName) throws GenericEntityException;
}