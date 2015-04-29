package org.userreg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.userreg.domain.SecurityQuestionRequest;
import org.userreg.domain.User;

@Controller
public class MainController {
		
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView loadMain() {
		return new ModelAndView("main");
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadMainPage() {
		return new ModelAndView("main");
	}

	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView loadSignupPage() {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("user",new User());
	    return mv;
	}

	@RequestMapping(value = "/securityQuestion", method = RequestMethod.POST)
	public ModelAndView loadSecurityQuestionPage(@RequestParam("userName")String userName, HttpServletRequest request, Model model) { 
		HttpSession session = request.getSession(false);
		Object object = session.getAttribute("user");
		if (object  == null){
			return new ModelAndView("main");
		}
		else{
			User user = (User)object;
			if (user.getUserName().equals(userName)){
				model.addAttribute("securityQuestion", new SecurityQuestionRequest());
				return new ModelAndView("securityquestion");
			}
			else{
				return new ModelAndView("main");
			}
		}		
	}
	
}
