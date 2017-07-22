package com.tcs.aqi.controllers;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tcs.aqi.beans.Pollutant;
import com.tcs.aqi.beans.SCL;
import com.tcs.aqi.beans.UserDetail;
import com.tcs.aqi.database.Testing;
import com.tcs.aqi.beans.Admin;

@SessionAttributes({"user","userType"})
@Scope("session")
@Controller
public class RequestController {	
	 public Date date;
	 public AQICalculation ac;
	
	 @RequestMapping("/")
	 public String welcome (ModelMap modelM)
	 {
		// ModelAndView model=new ModelAndView("index","command", new com.javatpoint.beans.Admin());
		// session.setAttribute("userType","jimmy");
		 modelM.addAttribute("pollutant",new Pollutant());
		 modelM.addAttribute("command",new Admin());
		 return "index";
	 
	 }
	 @RequestMapping(value = "/homepage")
	 public String login ()
	 {
		 return "redirect:/";
	 }
	 @RequestMapping(value = "/form",method =  RequestMethod.GET)
		public String showForm(ModelMap model)
		{
			String userType= (String)model.get("userType");
			
			System.out.println(userType);
			if(userType!=null && userType.equals("admin")){
				model.addAttribute("command", new Pollutant());
				return "input";
			}else
				return "redirect:/";
		}
	
	 @RequestMapping(value = "/logout",method =  RequestMethod.GET)
		public String logOut(ModelMap model)
		{
			model.addAttribute("userType","");
			model.addAttribute("user",new Admin());
			
			return "redirect:/";
		}
	 
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Pollutant emp ,ModelMap model){
		ac = new AQICalculation();
		ac.calculate(emp, model);
		ac.databaseCall();
		return "Datadisplay";
	}
	
	
	@RequestMapping(value = "/admininput",method = RequestMethod.GET)
	public String adminLogin(@ModelAttribute("adminDetail") Admin adminDetail,ModelMap model){
		
		System.out.println(adminDetail.getUsername()+" "+adminDetail.getPassword());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		boolean check = testing.checkAdmin(adminDetail.getUsername(),adminDetail.getPassword());
		if (check){
			
			model.addAttribute("userType","admin");
			model.addAttribute("user", adminDetail);
			return "redirect:/adminInput";	
		}
		else
			return "redirect:/";
		
	}
	
	@RequestMapping(value = "/adminInput")
	public String adminInput (){
		return "AdminInput";
	}
	
	@RequestMapping(value = "/userLogin")
	public String userLogin(@ModelAttribute("adminDetail") Admin adminDetail){
		
		System.out.println(adminDetail.getUsername()+" "+adminDetail.getPassword());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		boolean check = testing.checkUser(adminDetail.getUsername(),adminDetail.getPassword());
		if (check)
			return "redirect:/loginIndex";
		else
			return "loginError";
		
	}
	
	@RequestMapping(value = "/loginIndex")
	public String loginIndex (){
		return "LoginIndex";
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search (){
		
		return new ModelAndView("OnSearch","command",new SCL());
	}
	@RequestMapping(value="/processsearch")
	public String onSearch(@ModelAttribute("scl")SCL scl,ModelMap model){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		System.out.println("Date: "+scl.getTodate()+"  "+scl.getFromdate());
		Pollutant pollutant = testing.dateAqi(scl.getState(), scl.getCity(), scl.getLocation(), Date.valueOf(LocalDate.now()));
		model.addAttribute("airQuality",pollutant);
		return "Search";
	}
	
	@RequestMapping(value = "/addscl")
	public ModelAndView addscl(){
		
		return new ModelAndView("AddSCL","command",new SCL());
	}
	
	@RequestMapping(value = "/processscl")
	public String processscl (@ModelAttribute("scl") SCL scl ){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		testing.addSCL(scl.getState(),scl.getCity(),scl.getLocation());
		return  "SclSuccess";
	}
	@RequestMapping(value = "/registerForm")
	public ModelAndView registrationForm(){
		return new ModelAndView("RegistrationForm","command",new UserDetail());
	}
	@RequestMapping(value = "/addUser")
	public String addUser(@ModelAttribute("user_") UserDetail user_){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		boolean exist = testing.addUser(user_.getfName(),user_.getlName(),user_.getEmail(),user_.getPassword(),user_.getState(),user_.getCity(),user_.getLocation());
		if(exist)
			return "UserExistErrorPage";
		else
			return "SignupSuccessfull";		
	}
}
	






/*@SessionAttributes({"user","userType"})
@Scope("session")
@Controller
public class RequestController {	
	 public Date date;
	 public AQICalculation ac;
	
	 @RequestMapping("/")
	 public String welcome (ModelMap modelM)
	 {
		// ModelAndView model=new ModelAndView("index","command", new Admin());
		// session.setAttribute("userType","jimmy");
		 modelM.addAttribute("pollutant",new Pollutant());
		 modelM.addAttribute("command",new Admin());
		 return "index";
	 
	 }
	 @RequestMapping(value = "/login")
	 public String login ()
	 {
		 return "redirect:/";
	 }
	 @RequestMapping(value = "/form",method =  RequestMethod.GET)
		public String showForm(ModelMap model)
		{
			String userType= (String)model.get("userType");
			
			System.out.println(userType);
			if(userType!=null && userType.equals("admin")){
				model.addAttribute("command", new Pollutant());
				return "input";
			}else
				return "redirect:/";
		}
	
	 @RequestMapping(value = "/logout",method =  RequestMethod.GET)
		public String logOut(ModelMap model)
		{
			model.addAttribute("userType","");
			model.addAttribute("user","");
			
			return "redirect:/";
		}
	 
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute("emp") Pollutant emp ,ModelMap model){
		ac = new AQICalculation();
		ac.calculate(emp, model);
		return "Datadisplay";
	}
	
	@RequestMapping(value = "/feedDatabase")
	public String databaseCall (){
		
		ac.databaseCall();
		return "ConfirmationPage";
	}
	
	@RequestMapping(value = "/admininput",method = RequestMethod.GET)
	public String adminLogin(@ModelAttribute("adminDetail") Admin adminDetail,ModelMap model){
		
		System.out.println(adminDetail.getUsername()+" "+adminDetail.getPassword());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		boolean check = testing.checkAdmin(adminDetail.getUsername(),adminDetail.getPassword());
		if (check){
			
			model.addAttribute("userType","admin");
			//model.addAttribute("user", adminDetail);
			return "redirect:/form";	
		}
		else
			return "redirect:/";
		
	}
	
	@RequestMapping(value = "/userLogin")
	public String userLogin(@ModelAttribute("adminDetail") Admin adminDetail){
		
		System.out.println(adminDetail.getUsername()+" "+adminDetail.getPassword());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		boolean check = testing.checkUser(adminDetail.getUsername(),adminDetail.getPassword());
		if (check)
			return "redirect:/login";
		else
			return "redirect:/loginError";
		
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search (){
		
		return new ModelAndView("OnSearch","command",new SCL());
	}
	@RequestMapping(value="/processsearch")
	public String onSearch(@ModelAttribute("scl")SCL scl,ModelMap model){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		System.out.println("Date: "+scl.getTodate()+"  "+scl.getFromdate());
		Pollutant pollutant = testing.dateAqi(scl.getState(), scl.getCity(), scl.getLocation(), Date.valueOf(LocalDate.now()));
		model.addAttribute("airQuality",pollutant);
		return "Search";
	}
	
	@RequestMapping(value = "/addscl")
	public ModelAndView addscl(){
		
		return new ModelAndView("AddSCL","command",new SCL());
	}
	
	@RequestMapping(value = "/processscl")
	public ModelAndView processscl (@ModelAttribute("scl") SCL scl ){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		testing.addSCL(scl.getState(),scl.getCity(),scl.getLocation());
		return  null;
	}
	@RequestMapping(value = "/registerForm")
	public ModelAndView registrationForm(){
		return new ModelAndView("RegistrationForm","command",new UserDetail());
	}
	@RequestMapping(value = "/addUser")
	public String addUser(@ModelAttribute("user_") UserDetail user_){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		boolean exist = testing.addUser(user_.getfName(),user_.getlName(),user_.getEmail(),user_.getPassword(),user_.getState(),user_.getCity(),user_.getLocation());
		if(exist)
			return "UserExistErrorPage";
		else
			return "SignupSuccessfull";		
	}
}
	

*/