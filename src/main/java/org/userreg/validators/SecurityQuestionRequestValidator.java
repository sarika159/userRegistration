package org.userreg.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.userreg.domain.SecurityQuestionRequest;

@Component
public class SecurityQuestionRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return SecurityQuestionRequest.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors,"answer", "required","Answer is required");

	}

}
