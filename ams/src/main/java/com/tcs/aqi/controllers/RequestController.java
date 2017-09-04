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
import org.springframework.web.servlet.ModelAndView;

import com.tcs.aqi.beans.Pollutant;
import com.tcs.aqi.beans.SCL;
import com.tcs.aqi.beans.UserDetail;
import com.tcs.aqi.database.Testing;
import com.tcs.aqi.beans.Admin;

@SessionAttributes({ "user", "userType", "message", "noti" })
@Scope("session")
@Controller
public class RequestController {
	public Date date;
	public ModelMap model1;

	@RequestMapping("/")
	public String welcome(ModelMap modelM) {

		modelM.addAttribute("command", new Admin());
		modelM.addAttribute("noti", "noti");
		return "index";

	}

	@RequestMapping(value = "/homepage")
	public String login() {
		return "redirect:/";
	}

}
