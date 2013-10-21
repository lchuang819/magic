/**
 * Powered by Chuang.Liu @2011-11-11
 * Mobile:15810848558
 * Email:lchuang819@163.com
 */
package com.apps.order.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.apps.order.constant.OrderActionType;
import com.apps.order.service.OrderService;
import com.magic.util.CommonUtil;
import com.magic.util.Debug;
import com.magic.util.ServiceUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author lchuang
 * @2011-11-11
 */
public class OrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String module = OrderAction.class.getName();
	
	@Autowired
	private OrderService orderService;
	
	public String executeOrderManager() throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Map params = request.getParameterMap();
		Debug.logInfo("executeOrderManager params:"+params, module);
		
		String actionType = request.getParameter("actionType");
		Debug.logInfo("PartyGroupAction actionType:"+actionType, module);
		
		String supplierId = request.getParameter("supplierId");
		String receiveProductStore = request.getParameter("receiveProductStore");
		String passBy = request.getParameter("passBy");
		String comments = request.getParameter("comments");
		String orderName = request.getParameter("orderName");
		
		//订单明细
		String dataset = request.getParameter("dataset");
		Debug.logInfo("dataset:"+dataset, module);
		
		String orderTypeId = request.getParameter("orderTypeId");
		Debug.logInfo("executeOrderManager orderTypeId:"+orderTypeId, module);
		
		Map context = new HashMap();
		context.put("supplierId", supplierId);
		context.put("receiveProductStore", receiveProductStore);
		context.put("passBy", passBy);
		context.put("comments", comments);
		context.put("orderTypeId", orderTypeId);
		context.put("orderName", orderName);
		
		context.put("dataset", dataset);
		
		Map results = null;
		try{
			
			if(OrderActionType.CREATE_ORDER.equals(actionType)){
				results = orderService.createOrderService(context);
			}
			
			if(ServiceUtil.isError(results)){
				Debug.logError("", module);
				CommonUtil.outFailureJson(response, ServiceUtil.getErrorMessage(results));
			}
			
		}catch (Exception e) {
			Debug.logError(e, module);
			CommonUtil.outFailureJson(response, e.getMessage());
		}
		
		CommonUtil.outSuccessJson(response, "操作成功");
		return null;
	}
	
}
