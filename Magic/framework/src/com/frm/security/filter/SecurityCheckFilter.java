package com.frm.security.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.magic.util.Debug;

/**
 * Servlet Filter implementation class SecurityCheckFilter
 */
public class SecurityCheckFilter implements Filter {
	
	public static final String module = SecurityCheckFilter.class.getName();

    /**
     * Default constructor. 
     */
    public SecurityCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Debug.logInfo("Start Security Check.", module);
		
		HttpServletRequest req = (HttpServletRequest) request;
	    HttpServletResponse res = (HttpServletResponse) response;
	   
	    HttpSession session = req.getSession(true);
	    //从session里取的用户名信息
	    String visitId = (String) session.getAttribute("visitId");
	    Map userInfo = (Map) session.getAttribute("userInfo");
	    
	    String userLoginId = "";
	    if(userInfo != null){
	    	userLoginId = (String) userInfo.get("userLoginId");
	    }
	    
	    Debug.logInfo("User ["+userLoginId+"] request uri:"  + req.getRequestURI(), module);
	    if(req.getRequestURI().indexOf("error.jsp") >= 0){
	    	chain.doFilter(request, response);
	    	return;
	    }
	   
	    //判断如果没有取到用户信息,就跳转到登陆页面
	    if (StringUtils.isEmpty(visitId)) {
	      //跳转到登陆页面
	    	Debug.logInfo("User ["+userLoginId+"] login failed.", module);
	    	res.sendRedirect("/Magic/error.jsp");
	    } else {
	    	Debug.logInfo("User ["+userLoginId+"] login successfully.", module);
	    	chain.doFilter(request, response);
	    }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
