/**
 * Powered by Lchuang @2011
 * Tel: 15810848558
 * E-mail: lchuang819@163.com
 */
package com.magic.util.hibernate;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.magic.util.Debug;

/**
 * @author lchuang
 *
 */
public class SequenceUtil {
//
//	public static final String module = SequenceUtil.class.getName();
//	private static String tableName = "ofbiztest.sequence_value_item";
//	private static String colName = "seq_name";
//	private static String colValue = "seq_id";
//	
//	@Qualifier("transactionTemplate")
//	private static TransactionTemplate transactionTemplate;
//
//	private static String seqNameValue = "SequenceName";
//
//	public static long idValue;
//	
//	private static Session session;
//	
//	@Qualifier("sessionFactory")
//	private static SessionFactory sessionFactory;
//	
//	/**
//	 * @return the sessionFactory
//	 */
//	public static SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	/**
//	 * @param sessionFactory the sessionFactory to set
//	 */
//	public static void setSessionFactory(SessionFactory sessionFactory) {
//		SequenceUtil.sessionFactory = sessionFactory;
//	}
//
//	/**
//	 * @return the transactionTemplate
//	 */
//	public static TransactionTemplate getTransactionTemplate() {
//		return transactionTemplate;
//	}
//
//	/**
//	 * @param transactionTemplate the transactionTemplate to set
//	 */
//	public static void setTransactionTemplate(
//			TransactionTemplate transactionTemplate) {
//		SequenceUtil.transactionTemplate = transactionTemplate;
//	}
//
//	public static synchronized String getNextSeqId(String seqName){
//		if(seqName != null && !"".equals(seqName)){
//			seqNameValue = seqName;
//		}
//		
//		Object nexSeqOjb = transactionTemplate.execute(new TransactionCallback<Object>(){
//
//			@Override
//			public Object doInTransaction(TransactionStatus ts) {
//				
//				try {
//					Debug.logInfo("seqNameValue::" + seqNameValue, module);
//					session = sessionFactory.getCurrentSession();
////					Transaction transact = session.getTransaction();
//					//transact.begin();
//					
//					Connection conn = session.connection();
//					//long nextNo = 10000;
//					
//					BigDecimal nextSeq = new BigDecimal("10000");
//
//					String SQL_GETNO = "select " + colValue + " from " + tableName + " where " + colName + " = ?";
//					
//					//insert into sequence_value_item (Party, seq_name) values(?, ?);
//					String SQL_INSERT = "INSERT INTO "+tableName+" ("+colName+", "+colValue+") VALUES(?,?)";
//					
//					//update sequence_value_item set seq_id = 1000 where seq_name = 'Party'
//					String SQL_GETNO_UPDATE = "UPDATE "+tableName+" set "+colValue+"=? WHERE "+colName+"=?";
//					
//					PreparedStatement pstmt = null;
//					try {
//						
//						Debug.logInfo("query sql:" + SQL_GETNO, module);
//						pstmt = conn.prepareStatement(SQL_GETNO);
//						pstmt.setString(1, seqNameValue);
//						ResultSet re = pstmt.executeQuery();
//						if (re.next()) { // 数据库存在最大ID记录
//							//nextNo = re.getLong(1) + 1L;
//							
//							nextSeq = re.getBigDecimal(1);
//							Debug.logInfo(seqNameValue+" current seq::" + nextSeq.toString(), module);
//							
//							nextSeq = nextSeq.add(new BigDecimal("1"));
//							
//							Debug.logInfo("nextNo::" + nextSeq.toString(), module);
//							re.close();
//							
//							pstmt = conn.prepareStatement(SQL_GETNO_UPDATE);
//							pstmt.setBigDecimal(1, nextSeq);
//							pstmt.setString(2, seqNameValue);
//							pstmt.executeUpdate();
//							
//							Debug.logInfo("SQL_GETNO_UPDATE::" + SQL_GETNO_UPDATE, module);
//							
//						} else {// 数据库不存在最大ID记录 就添加一个初始值
////							nextNo = CommonDefine.synchronousID;
//							Debug.logInfo("SQL_INSERT::" + SQL_INSERT, module);
//							pstmt = conn.prepareStatement(SQL_INSERT);
//							pstmt.setString(1, seqNameValue);
//
//							// TODO 在线激活方式
//							pstmt.setBigDecimal(2, nextSeq); // 服务器端设置为1开始
//							pstmt.executeUpdate();
//
//						}
//					} catch (SQLException e) {
//						//transact.rollback();
//						Debug.logError(e, module);
//					} finally {
//						if (conn != null) {
//							try {
//								//session.getBatcher().closeConnection(conn);
//								//transact.rollback();
//								conn.close();
//							} catch (SQLException e) {
//								Debug.logError(e, module);
//							}
//						}
//
//					}
//					
////					session.flush();
//					//transact.commit();
//					Debug.logInfo(seqNameValue+" next sequence:" + nextSeq.toString(), module);
//					return nextSeq.toString();
//				} catch (Exception e) {
//					ts.setRollbackOnly();
//					return new Object();
//				}
//				
//			}
//			
//		});
//		
//		return nexSeqOjb.toString();
//	}
//	
}
