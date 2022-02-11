package com.hcl.msi.noram2.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.msi.noram2.Service.Noram2AdminService;

@Controller
@SessionAttributes({ "userName" })
public class Noram2LoginController {
	@Autowired
	Noram2AdminService service;

	@RequestMapping(value = "/RegisterNewUser", method = RequestMethod.GET)
	public ModelAndView showRegistrationForm(ModelAndView model) {
		model.setViewName("Register");
		return model;
	}

	@RequestMapping(value = "/RegisterNewUser", method = RequestMethod.POST)
	public ModelAndView retrieveCustomerDetails(@RequestParam Map<String, String> requestAllParams, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView("Register");
		modelAndView.addObject("message", service.addUserr(requestAllParams));
		return modelAndView;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showLoginForm(ModelAndView model) {
		model.setViewName("Login");
		return model;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView authenticateUser(@RequestParam Map<String, String> requestAllParams, ModelAndView model) {
		String message = service.authenticateUser(requestAllParams);
		if (message.equalsIgnoreCase("Invalid")) {
			model.addObject("message", "Incorrect Credentials");
			model.setViewName("Login");
		} else if (requestAllParams.get("password").equalsIgnoreCase("User@1234")) {
			model.addObject("message", "default");
			model.addObject("emailId", requestAllParams.get("emailAddress"));
			model.setViewName("ChangePassword");
		} else {
			model.addObject("message", message);
			model.addObject("userName", message);
			model.setViewName("Welcome");
		}
		return model;
	}

	@RequestMapping(value = "/changePwd", method = RequestMethod.GET)
	public ModelAndView showChangePwdPage(ModelAndView model) {
		model.setViewName("ChangePassword");
		return model;
	}

	@RequestMapping(value = "/changePwd", method = RequestMethod.POST)
	public ModelAndView changePwd(@RequestParam Map<String, String> requestAllParams, ModelAndView modelAndView) {
		modelAndView.addObject("message", service.changePwd(requestAllParams));
		modelAndView.setViewName("Login");
		return modelAndView;
	}

}
