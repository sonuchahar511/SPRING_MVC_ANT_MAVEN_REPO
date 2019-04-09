package com.chahar.spring.mvc.dto.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employeeVo")
public class EmployeeListVO {
	
	@XmlElement(name="employees")
	private List<EmployeeVO> employeeList = new ArrayList<EmployeeVO>();

	public List<EmployeeVO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeVO> employeeList) {
		this.employeeList = employeeList;
	}
	 
}
