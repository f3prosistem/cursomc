package com.f3pro.cursomc.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidatationError extends StandarError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessege> errors = new ArrayList<>();

	public ValidatationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessege> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String messege) {
		errors.add(new FieldMessege(fieldName, messege));	
	}

	
	
}
