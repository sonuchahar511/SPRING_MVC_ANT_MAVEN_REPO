package com.chahar.spring.mvc.interceptors;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestTimeLoggerInterceptor  extends HandlerInterceptorAdapter{
	private static final Logger LOG = LogManager.getLogger(RequestTimeLoggerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("requestStartTime", new Date());
		
		LOG.info("preHandle() called ");
		
		return true;
	}
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		Date requestStartTime = (Date) request.getAttribute("requestStartTime");
		long miliseconds = new Date().getTime() - requestStartTime.getTime(); 
		
		String url = request.getRequestURL().toString();
		
		LOG.info("postHandle(): Time taken by url: "+ url +" -> "+ miliseconds+" ms ");
		
		request.removeAttribute("requestStartTime");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			 Exception ex) throws Exception {
		LOG.info("afterCompletion() called ");
	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		LOG.info("afterConcurrentHandlingStarted() called ");
	}
	
}
