package com.chacha.guide.signup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chacha.guide.signup.service.DatabaseService;

@Controller
@RequestMapping("/validation")
public class ValidationController {
	
	private final DatabaseService databaseService;
	
	@Autowired
	public ValidationController(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}

	@RequestMapping(value="/email", method=RequestMethod.POST)
	@ResponseBody
	public String isUniqueEmail(@RequestParam("value") String email) {
		return String.valueOf(databaseService.isUniqueEmail(email));
	}
	
	@RequestMapping(value="/handle", method=RequestMethod.POST)
	@ResponseBody
	public String isUniqueHandle(@RequestParam("value") String handle) {
		return String.valueOf(databaseService.isUniqueHandle(handle));
	}
	
	@RequestMapping(value="/ssn", method=RequestMethod.POST)
	@ResponseBody
	public String isUniqueSSN(@RequestParam("value") String ssn) {
		return String.valueOf(databaseService.isUniqueSSN(ssn));
	}
	
	@RequestMapping(value="/ein", method=RequestMethod.POST)
	@ResponseBody
	public String isUniqueEIN(@RequestParam("value") String ein) {
		return String.valueOf(databaseService.isUniqueEIN(ein));
	}
}
