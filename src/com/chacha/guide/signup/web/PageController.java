package com.chacha.guide.signup.web;

import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chacha.guide.signup.beans.Gender;
import com.chacha.guide.signup.beans.GovernmentIdentifierType;
import com.chacha.guide.signup.beans.OldWorldUser;
import com.chacha.guide.signup.service.DatabaseService;


@Controller
@RequestMapping("/signup")
public class PageController {
	
	private final DatabaseService databaseService;
	
	@Autowired
	public PageController(DatabaseService databaseService) {
		super();
		this.databaseService = databaseService;
	}
	
	@RequestMapping(value="/splash", method=RequestMethod.GET)
	public String splash() {
		return "splash";
	}
	
	@RequestMapping(value="/inputform", method=RequestMethod.GET)
	public String formLoad() {
		return "input-form";
	}
	
	@RequestMapping(value="/completeform", method=RequestMethod.POST)
	public String saveInput(
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam String middleInitial,
			@RequestParam String email, @RequestParam String handle, @RequestParam String password,
			@RequestParam String gender, @RequestParam String birthdate,
			@RequestParam String governmentIdType, @RequestParam String governmentId,
			@RequestParam String address1, @RequestParam String address2,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String postalCode, @RequestParam String phone) {
		
		OldWorldUser user = new OldWorldUser();
		user.setFirstName(firstName);
		user.setMiddleInitial(middleInitial);
		user.setLastName(lastName);
		user.setEmailAddress(email);
		user.setHandle(handle);
		user.setPassword(password);
		user.setGender(Gender.valueOf(gender));
		user.setBirthDate(DateTimeFormat.shortDate().parseDateTime(birthdate).toDateMidnight());
		user.setGovernmentIdType(GovernmentIdentifierType.valueOf(governmentIdType));
		user.setGovernmentId(governmentId.replace("-", ""));
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setCity(city);
		user.setState(state);
		user.setPostalCode(postalCode);
		user.setPhoneNumber(phone.replace("-", "").replace("(", "").replace(")", ""));
		
		databaseService.saveUser(user);
		
		return "finished";
	}
	
}
