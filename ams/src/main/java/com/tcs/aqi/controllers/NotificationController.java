package com.tcs.aqi.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({ "user", "userType", "message", "noti" })
@Scope("session")
@Controller
public class NotificationController {

	@RequestMapping(value = "/getNotification", method = RequestMethod.GET)
	public String getNotiList() {
		// model.addAttribute("noti","1st noti");
		System.out.println("\n\ninside getNoti\n\n");
		return "Notification";
	}

}
