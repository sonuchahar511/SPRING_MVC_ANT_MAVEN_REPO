package com.chahar.spring.mvc.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeBasedAccessCustomInterceptor extends HandlerInterceptorAdapter{
	private static final Logger LOG = LogManager.getLogger(TimeBasedAccessCustomInterceptor.class);
	
	private int openingTime;
	private int closingTime;
	
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
			throws Exception {
		
	Calendar cal = Calendar.getInstance();
	
	int hour = cal.get(cal.HOUR_OF_DAY);
	
	if ( (hour >= openingTime ) && ( hour <= closingTime ) ) {
			LOG.info("TimeBasedAccessInterceptor call PASS");	
			return true;
		}else {
			LOG.info("TimeBasedAccessInterceptor call FAIL");
			/*response.sendRedirect("http://localhost:8080/springmvcproject/officeHourMessagePage.html");*/
			
			//TODO: Render static html page
			response.sendRedirect("officeHourMessagePage.html");
			return false;
		}
	
	}
	
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}
	
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}
}
