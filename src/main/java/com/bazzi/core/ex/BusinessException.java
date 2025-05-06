package com.bazzi.core.ex;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -4780315912126538513L;
	private final String code;
	private final String message;

	public BusinessException(String code, String message) {
		this.message = message;
		this.code = code;
	}

}
