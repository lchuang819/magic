/**
 * Powered by Chuang.Liu @2011-11-15
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.order.service;

import java.util.Date;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.commons.beanutils.BeanUtils;

import com.apps.order.constant.OrderConstant;
import com.apps.order.entitymodel.OrderHeader;
import com.apps.order.entitymodel.OrderItem;
import com.apps.order.entitymodel.OrderItemId;
import com.apps.order.entitymodel.OrderRole;
import com.apps.order.entitymodel.OrderRoleId;
import com.magic.exception.GeneralRuntimeException;
import com.magic.service.BaseService;
import com.magic.service.ExecuteServiceException;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.magic.util.UtilValidate;

/**
 * @author lchuang
 * @2011-11-15
 */
public class OrderService extends BaseService {

	public static final String module = OrderService.class.getName();
	
	/**
	 * 创建订单 包含 订单头 订单项 订单角色
	 * @param context
	 * @return
	 * @throws ExecuteServiceException
	 */
	public Map<String, Object> createOrderService(Map<String, Object> context) throws ExecuteServiceException{
		
		String supplierId = (String) context.get("supplierId");
		String passBy = (String) context.get("passBy");
		String receiveProductStore = (String) context.get("receiveProductStore");
		String comments = (String) context.get("comments");
		String orderTypeId = (String) context.get("orderTypeId");
		String orderName = (String) context.get("orderName");
		String orderId = (String) context.get("orderId");
		
		String dataset = (String) context.get("dataset");
		
		//获得订单号
		if(UtilValidate.isEmpty(orderId)){
			orderId = delegator.getNextSeqId("OrderHeader");
			if(OrderConstant.ORDER_TYPE_PURCHASE.equals(orderTypeId)){
				orderId = OrderConstant.PURCHASE_ORDER_NO_PREFIX + orderId;
			}else if(OrderConstant.ORDER_TYPE_SALES.equals(orderTypeId)){
				orderId = OrderConstant.SALES_ORDER_NO_PREFIX + orderId;
			}else if(OrderConstant.ORDER_TYPE_PURCHASE_RETURN.equals(orderTypeId)){
				orderId = OrderConstant.PURCHASE_RETURN_ORDER_NO_PREFIX + orderId;
			}else if(OrderConstant.ORDER_TYPE_SALES_RETURN.equals(orderTypeId)){
				orderId = OrderConstant.SALES_RETURN_ORDER_NO_PREFIX + orderId;
			}
		}
		
		Debug.logInfo("Get orderId:" + orderId, module);
		
		//创建订单头信息
		OrderHeader orderHeader = new OrderHeader();
		orderHeader.setOrderId(orderId);
		orderHeader.setOrderTypeId(orderTypeId);
		orderHeader.setStatusId(OrderConstant.STATUS_ORDER_CREATED);
		orderHeader.setOrderDate(new Date());
		orderHeader.setOriginFacilityId(supplierId);
		orderHeader.setTransactionId(passBy);
		orderHeader.setProductStoreId(receiveProductStore);
		orderHeader.setOrderName(comments);
		orderHeader.setOrderName(orderName);
		
		delegator.saveEntity(orderHeader);
		
		//订单 代理供应商
		createOrderRole(orderId, supplierId, "SUPPLIER_AGENT");
		createOrderRole(orderId, passBy, "EMPLOYEE");
		
		boolean isArray = JSONSerializer.toJSON(dataset).isArray();
		
		if(isArray){
			
			JSONArray jsonarray = JSONArray.fromObject(dataset);
			for(Object o : jsonarray){
				createOrderItem(orderId, o);
			}
			
		}else{
			createOrderItem(orderId, JSONObject.fromObject(dataset));
		}
		
		Map returnMap = ServiceUtil.returnSuccess();
		return returnMap;
	}
	
	/**
	 * 创建OrderItem
	 * @param orderId
	 * @param orderItemMap
	 * @return
	 */
	private OrderItem createOrderItem(String orderId, Object orderItemData){
		
		JSONObject orderItemMap = JSONObject.fromObject(orderItemData);
		
		OrderItemId id = new OrderItemId();
		String orderItemSeqId = delegator.getNextSeqId("OrderItem");
		
		Debug.logInfo("createOrderItem[orderId="+orderId+"][orderItemSeqId="+orderItemSeqId+"]:" + orderItemMap, module);
		
		id.setOrderId(orderId);
		id.setOrderItemSeqId(orderItemSeqId);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setId(id);
		orderItem.setOrderItemTypeId("PRODUCT_ORDER_ITEM");
		
		try {
			BeanUtils.populate(orderItem, orderItemMap);
			delegator.saveEntity(orderItem);
		} catch (Exception e) {
			Debug.logError(e, module);
			throw new GeneralRuntimeException(e);
		}
		
		return orderItem;
		
	}
	
	/**
	 * 创建订单角色[供应商 - 收货人]
	 * @return
	 */
	private OrderRole createOrderRole(String orderId, String partyId, String roleTypeId){
		
		OrderRoleId id = new OrderRoleId(orderId, partyId, roleTypeId);
		OrderRole orderRole = new OrderRole(id);
		delegator.saveEntity(orderRole);
		
		return orderRole;
	}
}
