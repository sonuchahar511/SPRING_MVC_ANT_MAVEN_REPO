package com.chahar.spring.mvc.controllers.exceptionhandling;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.chahar.spring.mvc.controllers.AbstractPageController;

@ControllerAdvice
public class GlobalExceptionHandlerController extends AbstractPageController{
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Invalid url mapping.")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		LOG.warn("IOException handler executed.");
	}
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception ex){
		LOG.info("SQLException Occured:: URL {} ,ex {} ",request.getRequestURL(),ex);
		
		ModelAndView view = new ModelAndView( "error_page/controllerAdvisedExceptionErrorPage");
		view.addObject("exception", ex);
		
		return view;
	}
	
}
