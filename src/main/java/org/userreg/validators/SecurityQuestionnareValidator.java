package org.userreg.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.userreg.domain.SecurityQuestionnare;

@Component
public class SecurityQuestionnareValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return SecurityQuestionnare.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors,"question1", "required","Question 1 selection is required");
		ValidationUtils.rejectIfEmpty(errors,"question2", "required","Question 2 selection is required");
		ValidationUtils.rejectIfEmpty(errors,"question3", "required","Question 3 selection is required");

		ValidationUtils.rejectIfEmpty(errors,"answer1", "required","Question 1 answer is required");
		ValidationUtils.rejectIfEmpty(errors,"answer2", "required","Question 2 answer is required");
		ValidationUtils.rejectIfEmpty(errors,"answer3", "required","Question 3 answer is required");

	}

}
