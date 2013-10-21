/**
 * Powered by Chuang.Liu @2011-11-4
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.magic.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;


/**
 * @author lchuang
 * @2011-11-4
 */
public class SequenceUtil {

	public static final String module = SequenceUtil.class.getName();
	
	private String tableName = "sequence_value_item";
	private String schema = "ofbiz";
	private String instance = "";
	private String colSeqName = "seq_name";
	private String colSeqId = "seq_id";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DataSourceTransactionManager dsTransactionManager;
	
	private DefaultTransactionDefinition dtf;
	
	public SequenceUtil(String schemaName, String tableName, String colSeqName, String colSeqId){
		dtf = new DefaultTransactionDefinition();
		dtf.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		
		this.schema = schemaName;
		this.tableName = tableName;
		this.colSeqName = colSeqName;
		this.colSeqId = colSeqId;
		
		this.instance = this.schema+"."+this.tableName;
	}
	
	public Long getNextSeqId(String seqName){
		return this.getNextSeqId(seqName, 10000L);
	}
	
	public synchronized Long getNextSeqId(String seqName, Long startSeq){
		
		TransactionStatus status = dsTransactionManager.getTransaction(dtf);
		
		String SQL_GETSEQ = "select " + colSeqId + " from " + this.instance + " where " + colSeqName + " = ?";
		
		//insert into sequence_value_item (Party, seq_name) values(?, ?);
		String SQL_INSERT = "INSERT INTO "+this.instance+" ("+colSeqName+", "+colSeqId+") VALUES(?,?)";
		
		//update sequence_value_item set seq_id = 1000 where seq_name = 'Party'
		String SQL_GETNO_UPDATE = "UPDATE "+this.instance+" set "+colSeqId+"=? WHERE "+colSeqName+"=?";

		if(startSeq == null){
			startSeq = new Long(10000);
		}
		
		Long currentSeq;
		Long nextSeq;
		
		try {
			
			currentSeq = jdbcTemplate.queryForObject(SQL_GETSEQ, Long.class, seqName);
			
			if(currentSeq != null){
				
				Debug.logInfo("Current seqName["+seqName+"] sequence value is " + currentSeq.toString(), module);
				nextSeq = currentSeq + 1;
				int insertRes = jdbcTemplate.update(SQL_GETNO_UPDATE, nextSeq, seqName);
				Debug.logInfo("Update new value["+seqName+"="+nextSeq.toString()+"], result:"+insertRes, module);
				
			} else {
				
				Debug.logInfo("Current seqName["+seqName+"] not in " + this.instance + ", Start Insert new value.", module);
				
				int insertRes = jdbcTemplate.update(SQL_INSERT, seqName, startSeq);
				Debug.logInfo("Insert new value["+seqName+"="+startSeq.toString()+"], result:"+insertRes, module);
				nextSeq = startSeq;
			}
			
		} catch (DataAccessException e) {
			Debug.logError(e, module);
			dsTransactionManager.rollback(status);
			throw e;
		}
		
		dsTransactionManager.commit(status);
		return nextSeq;
	}
}
