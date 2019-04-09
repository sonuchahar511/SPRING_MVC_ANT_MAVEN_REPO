package com.chahar.spring.mvc.controllers.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chahar.spring.mvc.controllers.AbstractPageController;

@Controller
public class ErrorController extends AbstractPageController{
	
	@RequestMapping(value = "errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
		LOG.info(" /errors + GET : ErrorController : started");
		 
        ModelAndView errorPage = new ModelAndView("error_page/uncatched_by_controller_generic_errorPage");
       
        int httpErrorCode =  (Integer) httpRequest .getAttribute("javax.servlet.error.status_code");
        
        String errorMsg = "";
        
        switch (httpErrorCode) {
            case 400:
                errorMsg = "Http Error Code: 400. Bad Request";
                break;
                
            case 401: 
                errorMsg = "Http Error Code: 401. Unauthorized";
                break;
                
            case 404:
                errorMsg = "Http Error Code: 404. Resource not found";
                break;
                
            case 500: 
                errorMsg = "Http Error Code: 500. Internal Server Error";
                break;
                
            default : 
            	errorMsg = "Unknown status: " +httpErrorCode +  " occured.";
        }
        errorPage.addObject("errorMsg", errorMsg);
        errorPage.addObject("httpErrorCode", httpErrorCode); 
        
        LOG.info(" /errors + GET : ErrorController ended: status {} , message {} ", httpErrorCode , errorMsg);
        
        
        return errorPage;
    }
     
}
