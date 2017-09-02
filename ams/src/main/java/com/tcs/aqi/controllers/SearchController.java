package com.tcs.aqi.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.aqi.beans.Pollutant;
import com.tcs.aqi.beans.SCL;
import com.tcs.aqi.database.Testing;

@SessionAttributes({"user","userType","message","noti"})
@Scope("session")
@Controller
public class SearchController {

	
	@RequestMapping(value = "/search")
	public String search (ModelMap model){
		
		String userType= (String)model.get("userType");
		
		System.out.println(userType);
		if(userType!=null && !userType.equals("")){
			model.addAttribute("command",new SCL());
			return "OnSearch";
		}else
			return "redirect:/";
		
	}
	/*
	@RequestMapping(value = "/search")
	public String search (ModelMap model){
		
		//String userType= (String)model.get("userType");
		
		//System.out.println(userType);
		//if(true){
			model.addAttribute("command",new SCL());
			List<String> state = new ArrayList<String>();
			state.add("Gujarat");
			state.add("Mh");
			state.add("Rj");
			state.add("Mp");
			model.addAttribute("stateList",state);
			return "searchPage";
		//}else
		//	return "redirect:/";
		
	}
	
	@RequestMapping(value="/btnClk",method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<List> geList(){
		 List<String> city = new ArrayList<String>();
			city.add("Kutch");
			city.add("China");
			city.add("Singapore");
			city.add("Malaysia");
			
			System.out.println("enter in controller ");
			return new ResponseEntity<List>(city, HttpStatus.OK);
	}
*/
	
	@RequestMapping(value="/processsearch")
	public String onSearch(@ModelAttribute("scl")SCL scl,ModelMap model){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing)context.getBean("testing");
		System.out.println("Date: "+scl.getTodate()+"  "+scl.getFromdate());
		Pollutant pollutant = testing.dateAqi(scl.getState(), scl.getCity(), scl.getLocation(), Date.valueOf(LocalDate.now()),scl.getTodate(),scl.getFromdate());
		model.addAttribute("airQuality",pollutant);
		return "Search";
	}
	
}
