package com.bankapp.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@ResponseBody
	public String home() {
		return "WORKING";
	}

}
