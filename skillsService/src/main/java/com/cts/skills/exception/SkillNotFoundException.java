package com.cts.skills.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class SkillNotFoundException extends RuntimeException {
	
	public SkillNotFoundException(String message) {
		super(message);
	}

}