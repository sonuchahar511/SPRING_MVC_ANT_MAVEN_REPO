package com.chahar.spring.mvc.controllers.exceptionhandling;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chahar.spring.mvc.controllers.AbstractPageController;
import com.chahar.spring.mvc.exceptions.CustomException;

@Controller
@RequestMapping(value="/exceptionHandling")
public class ExceptionPocController extends AbstractPageController{
	
	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public ModelAndView first() throws CustomException {
		LOG.info("/first + GET -> Throwing CustomException");
		throw new CustomException("This is a message from first controller");
	}
	
	//Exception Handling at controller level.
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(CustomException ex) {
		LOG.info("Handled CustomException {} " , ex);
		
		ModelAndView model = new ModelAndView("error_page/controllerHandledErrorPage");
		model.addObject("exception", ex);
		return model;
	}
	
	//Handled at @ControllerAdvice
	@RequestMapping(value = "/second", method = RequestMethod.GET)
	public ModelAndView second()  throws SQLException{
		LOG.info("/second + GET -> Throwing SQLException");
		throw new SQLException("This is a message from second controller");
	}
	
	//Handled at @ControllerAdvice
	@RequestMapping(value = "/third", method = RequestMethod.GET)
	public ModelAndView third()  throws IOException{
		LOG.info("/third + GET -> Throwing IOException");
		throw new IOException("This is a message from third controller");
	}
	
	@RequestMapping(value = "/fourth", method = RequestMethod.GET)
	public ModelAndView forth()  throws IllegalArgumentException{
		LOG.info("/fourth + GET -> Throwing IllegalArgumentException");
		throw new IllegalArgumentException("This is a message from fourth controller");
	}
	
	@RequestMapping(value = "/fifth", method = RequestMethod.GET)
	public ModelAndView fifth()  throws RuntimeException{
		LOG.info("/fifth + GET -> Throwing RuntimeException");
		throw new RuntimeException("This is a message from fifth controller");
	}
	
	@RequestMapping(value = "/sixth", method = RequestMethod.GET)
	public ModelAndView sixth()  throws NullPointerException{
		LOG.info("/sixth + GET -> Throwing NullPointerException");
		throw new NullPointerException("This is a message from sixth controller");
	}
	
}
