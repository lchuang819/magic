package com.magic.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class CommonUtil {
	
	public static final String module = CommonUtil.class.getName();
	
	public static void outJson(HttpServletResponse response, JSON json) throws IOException{
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.print(json);
		writer.flush();
		writer.close();
		Debug.logInfo("Out json data: "+json+" complete", module);
	}
	
	public static void outSuccessJson(HttpServletResponse response, String msg) throws IOException{
		outSuccessJson(response, msg, null);
	}
	
	public static void outSuccessJson(HttpServletResponse response, String msg, JSONObject data) throws IOException {
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		json.put("success", true);
		json.put("ResponseBody", data);
		outJson(response, json);
	}
	
	public static void outFailureJson(HttpServletResponse response, String msg) throws IOException{
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		json.put("success", false);
		json.put("failure", true);
		outJson(response, json);
	}
}
