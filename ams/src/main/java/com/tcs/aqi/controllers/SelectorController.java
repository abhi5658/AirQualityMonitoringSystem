package com.tcs.aqi.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user","userType","message","noti"})
@Scope("session")
public class SelectorController
{
	//@RequestMapping(value="/search/{state}")
}