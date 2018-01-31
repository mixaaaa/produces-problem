package com.showcase.spring.producesproblem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.showcase.spring.producesproblem.resource.ProblemResource;

@ControllerAdvice
public class AbstractController {

	@ExceptionHandler
	public ResponseEntity<ProblemResource> handleException(final Exception exception, final HttpServletRequest request) {
		// create result objects
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		ProblemResource problemResource = new ProblemResource();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// exception handling
		if (exception instanceof RuntimeException) {
			problemResource.setErrMsg(String.format("Showcase Error: %s", exception.getMessage()));
			status = HttpStatus.BAD_REQUEST;
		} else {
			problemResource
					.setErrMsg(String.format("Unknown Error: class=%s, msg=%s", exception.getClass(), exception.getMessage()));
		}

		// return possible json object
		return new ResponseEntity<>(problemResource, headers, status);
	}

}
