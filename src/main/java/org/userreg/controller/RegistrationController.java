package org.userreg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.userreg.domain.SecurityQuestionnare;
import org.userreg.domain.SecurityQuestionRequest;
import org.userreg.domain.User;
import org.userreg.validators.SecurityQuestionnareValidator;
import org.userreg.validators.SecurityQuestionRequestValidator;
import org.userreg.validators.UserValidator;

@Controller
@RequestMapping(value="/User")
public class RegistrationController {
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private SecurityQuestionnareValidator securityQuestionnareValidator;
	
	@Autowired
	private SecurityQuestionRequestValidator securityQuestionRequestValidator;

	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(User user,HttpServletRequest request,Model model, BindingResult result){
		userValidator.validate(user, result);	
		if (result.hasErrors()){
			return "signup";
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("user", user);
		model.addAttribute("securityQuestionnare", new SecurityQuestionnare());
		return "questions";
	}

	@RequestMapping(value="/saveAnswers", method=RequestMethod.POST)
	public String saveAnswersToSession(@ModelAttribute("userQuestionnare") SecurityQuestionnare userQuestionnare,HttpServletRequest request,BindingResult result){
		securityQuestionnareValidator.validate(userQuestionnare, result);	
		if (result.hasErrors()){
			return "questions";
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("questionnare", userQuestionnare);

		return "main";
	}
	
	@RequestMapping(value="/validateAnswer", method=RequestMethod.POST)
	public String validateAnswer(@ModelAttribute("securityQuestion") SecurityQuestionRequest securityQuestion, BindingResult result, HttpServletRequest httpRequest){
		securityQuestionRequestValidator.validate(securityQuestion, result);
		if(result.hasErrors()){
			return "securityquestion";
		}
		HttpSession session = httpRequest.getSession(false);
		SecurityQuestionnare securityQuestionnare = (SecurityQuestionnare) session.getAttribute("questionnare");
		if (securityQuestionnare.getAnswer1().equals(securityQuestion.getAnswer())){
			return "success";
		}
		else{
			result.addError(new ObjectError("securityQuestionRequest", "Answer entered doesn't match. Please try again"));
			return "securityquestion";
		}
	}

}
