package com.tcs.aqi.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tcs.aqi.beans.Admin;
import com.tcs.aqi.beans.UserDetail;
import com.tcs.aqi.database.Testing;

@SessionAttributes({ "user", "userType", "message", "noti" })
@Scope("session")
@Controller
public class LoginController {

	@RequestMapping(value = "/registerForm")
	public String registrationForm(ModelMap model) {

		// String str= (String)model.get("userType");
		// if(str==null || str==""){
		model.addAttribute("command", new UserDetail());
		return "RegistrationForm";
		// }else
		// return "redirect:/";
	}

	@RequestMapping(value = "/addUser")
	public String addUser(@ModelAttribute("user_") UserDetail user_, ModelMap model) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing) context.getBean("testing");
		boolean exist = testing.addUser(user_.getfName(), user_.getEmail().toLowerCase(), user_.getPassword(),
				user_.getState().toUpperCase(), user_.getCity().toUpperCase(), user_.getLocation().toUpperCase());
		if (exist) {
			model.addAttribute("message", "userExists");
		} else
			model.addAttribute("message", "sign up successfull");
		return "redirect:/";
	}

	@RequestMapping(value = "/admininput", method = RequestMethod.GET)
	public String adminLogin(@ModelAttribute("adminDetail") Admin adminDetail, ModelMap model) {

		System.out.println(adminDetail.getUsername() + " " + adminDetail.getPassword());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing) context.getBean("testing");
		boolean check = testing.checkAdmin(adminDetail.getUsername(), adminDetail.getPassword());
		if (check) {

			model.addAttribute("userType", "admin");
			model.addAttribute("user", adminDetail);
			return "redirect:/adminInput";
		} else {
			model.addAttribute("message", "Invalid Credentials!!! Please Try Again");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/userLogin")
	public String userLogin(@ModelAttribute("adminDetail") Admin adminDetail, ModelMap model) {

		System.out.println(adminDetail.getUsername() + " " + adminDetail.getPassword());
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Testing testing = (Testing) context.getBean("testing");
		boolean check = testing.checkUser(adminDetail.getUsername(), adminDetail.getPassword());
		if (check) {
			model.addAttribute("userType", "user");
			model.addAttribute("user", adminDetail);
			return "redirect:/";
		} else {
			model.addAttribute("message", "Invalid Credentials!!! Please Try Again");
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(ModelMap model, SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

}
