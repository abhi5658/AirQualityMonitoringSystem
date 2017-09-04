package com.tcs.aqi.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.aqi.beans.Pollutant;
import com.tcs.aqi.beans.SCL;
import com.tcs.aqi.database.AQICalculation;
import com.tcs.aqi.database.Testing;

@SessionAttributes({"user","userType","message","noti"})
@Scope("session")
@Controller
public class AdminController {
	
	public AQICalculation ac;
	
	@RequestMapping(value = "/form",method =  RequestMethod.GET)
	public String showForm(ModelMap model)
	{
		//String userType= (String)model.get("userType");	
		//System.out.println(userType);
		
		//if(userType!=null && userType.equals("admin")){
			model.addAttribute("command", new Pollutant());
			return "input";
		//}else
			//return "redirect:/";
	}
	 
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Pollutant emp ,ModelMap model){
		ac = new AQICalculation();
		ac.calculate(emp, model);
		ac.databaseCall();
		model.addAttribute("message","data added successfully");
		return "redirect:/form";
	}
	
	@RequestMapping(value = "/adminInput")
	public String adminInput (ModelMap model){
	return "AdminInput";
	}
	
	@RequestMapping(value = "/addscl")
	public String addscl(ModelMap model){
		// String userType= (String)model.get("userType");
		// System.out.println(userType);
	
		//if(userType!=null && userType.equals("admin")){
			model.addAttribute("command",new SCL());
			return "AddSCL";
		//}
	//	else
		//	return "redirect:/";
	}
	
	@RequestMapping(value = "/processscl")
	public String processscl (@ModelAttribute("scl") SCL scl, ModelMap model ){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		testing.addSCL(scl.getState(),scl.getCity(),scl.getLocation());
		model.addAttribute("message","location added successfully");
		return  "redirect:/addscl";
	}
	
	
}
