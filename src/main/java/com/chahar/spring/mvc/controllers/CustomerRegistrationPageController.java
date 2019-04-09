package com.chahar.spring.mvc.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chahar.spring.mvc.dto.UserDto;
import com.chahar.spring.mvc.dto.form.RegistrationForm;

@Controller
@RequestMapping("/customer")
public class CustomerRegistrationPageController extends AbstractPageController{
	
	@RequestMapping(value="/registrationPage",method=RequestMethod.GET)
	public String registerPage(final Model model) {
		LOG.info(" /registerPage + GET ");
		
		return "customerRegistrationPage";
	}
	
	@RequestMapping(value="/createAccount1",method=RequestMethod.GET)
	public String createAccount1(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,@RequestParam("email") String email) {
		LOG.info(" /createAccount1 + GET , data: firstname: {} ,lastname: {} , email: {}" , firstName,lastName,email);
		
		RegistrationForm registrationForm = new RegistrationForm(firstName, lastName, email);
		
		LOG.info(registrationForm);
		
		return "customerRegistrationPage";
	}
	
	/*
	 * Form submit from Client: Don't use @RequestBody
	 * */
	@RequestMapping(value="/createAccount2",method=RequestMethod.POST)
	public String createAccount2(RegistrationForm registrationForm) {
		LOG.info(" /createAccount2 + POST , data: {} " , registrationForm);
		
		return "customerRegistrationPage";
	}
	/*
	 * Path Variable POC
	 * **/
	@RequestMapping(value="accountProfile/{customer}/addresses/{address}", method=RequestMethod.GET)
	public String displayAddressDetails(@PathVariable("customer") String customerId, @PathVariable("address") String addressId) {
		
		LOG.info(" /accountProfile + GET , customerId: {} , addressId: {} " , customerId, addressId);
		
		return "customerRegistrationPage";
	}
	
	/*
	 * 
	 * **/
	@RequestMapping(value="registrationPage4", method=RequestMethod.GET)
	public String createAccount4(@ModelAttribute("abcForm") RegistrationForm registerForm,Model model) {
		LOG.info(registerForm);
		registerForm.setFirstname("yash1");
		registerForm.setLastname("chahar1");
		registerForm.setEmail("email");
		
		model.addAttribute("message", "test message in model attribute");
		
		LOG.info(" /registrationPage4 + GET");
		
		return "customerRegistrationPage";
	}
	
	@ModelAttribute("user")
	public UserDto userDetail() {
		UserDto result = new UserDto("anonymous","anonymous1",new Date());
		
		LOG.info("model user: {} ", result);
		
		return result;
	}
	
	/*@RequestMapping(value="sessionAttributesPOC", method=RequestMethod.GET)
	public String createAccount4(HttpServletRequest request ,@SessionAttribute("registration") RegistrationForm registerForm ) {
		LOG.info(registerForm);
		registerForm.setFirstname("yash1");
		registerForm.setLastname("chahar1");
		registerForm.setEmail("email");
		
		return "customerRegistrationPage";
	}*/
}
