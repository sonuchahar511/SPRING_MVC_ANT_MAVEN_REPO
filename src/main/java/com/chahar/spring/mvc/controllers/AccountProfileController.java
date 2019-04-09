package com.chahar.spring.mvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chahar.spring.mvc.dto.form.AccountProfileForm;
import com.chahar.spring.mvc.dto.form.AccountProfileResponse;
import com.chahar.spring.mvc.dto.response.EmployeeListVO;
import com.chahar.spring.mvc.dto.response.EmployeeVO;

@Controller
@RequestMapping("/customer/profile")
public class AccountProfileController extends AbstractPageController{
	
	@RequestMapping(method=RequestMethod.GET)
	public String accountProfilePage(final Model model) {
		LOG.info(" /customer/profile + GET ");
		
		return "accountProfile";
	}
	
	
	@RequestMapping(value="updateProfile" , method=RequestMethod.POST , 
			consumes="application/json",
			produces="application/json")
	public @ResponseBody AccountProfileResponse updateProfile(@RequestBody AccountProfileForm profileForm) {
		LOG.info(" /customer/profile/updateProfile + POST , data: {} " , profileForm );
		
		//TODO: Custom Logic
		AccountProfileResponse response = null;
		if(profileForm.getEmail().contains("@gmail")) {
			response = new AccountProfileResponse(true,"Profile Data is saved successfully....");
		}else {
			response = new AccountProfileResponse(false, "error occured while saving Account Profile Data: reason: only gmail address is allowed in email field");
		}
		
		return response;
	}
	
	/*@RequestMapping(value="updateProfileXml" , method=RequestMethod.POST , 
			consumes="application/json",
			produces="application/xml")
	public @ResponseBody AccountProfileResponse updateProfile_XmlCall(@RequestBody AccountProfileForm profileForm) {
		LOG.info(" /customer/profile/updateProfileXml + POST , data: {} " , profileForm );
		
		//Custom Logic
		AccountProfileResponse response = null;
		if(profileForm.getEmail().contains("gmail")) {
			response = new AccountProfileResponse(true,"Profile Data is saved successfully....");
		}else {
			response = new AccountProfileResponse(false, "error occured while saving Account Profile Data: reason: only gmail address is allowed in email field");
		}
		
		return response;
	}*/
	
	
	@RequestMapping(value="employeeListXml" , method=RequestMethod.POST , 
		consumes="application/json",
		produces="application/xml"
		)
    public @ResponseBody EmployeeListVO getAllEmployees(@RequestBody AccountProfileForm profileForm) 
    {
		LOG.info(" /customer/profile/employeeListXml + POST , data: {} " , profileForm );
		
        EmployeeListVO employees = new EmployeeListVO();
         
        EmployeeVO empOne = new EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        EmployeeVO empTwo = new EmployeeVO(2,"Amit","Singhal","asinghal@yahoo.com");
        EmployeeVO empThree = new EmployeeVO(3,"Kirti","Mishra","kmishra@gmail.com");
         
        employees.getEmployeeList().add(empOne);
        employees.getEmployeeList().add(empTwo);
        employees.getEmployeeList().add(empThree);
        
        return employees;
    }
	
	@RequestMapping(value = "/employees/{id}" , method=RequestMethod.GET , produces="application/xml")
    @ResponseBody
    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id1)
    {
		LOG.info(" /customer/profile/employees/{id} + GET , id: {} " ,  id1);
		
        if (id1 <= 3) {
            EmployeeVO employee = new EmployeeVO(id1,"Lokesh","Gupta","howtodoinjava@gmail.com");
            return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
        }
        
        return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
    }
      
}
