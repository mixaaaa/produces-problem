package com.showcase.spring.producesproblem.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.showcase.spring.producesproblem.exception.ShowcaseException;
import com.showcase.spring.producesproblem.resource.InputResource;

@RestController
@RequestMapping("showcase")
public class InputController {

	@RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE,
			produces = { TEXT_PLAIN_VALUE, APPLICATION_JSON_VALUE })
	public ResponseEntity<String> showcaseInput(@RequestBody InputResource input) {
		String result;
		if (input != null && input.getInputValue() != null && input.getSuccess()) {
			result = input.getInputValue() + " + success";
		} else {
			throw new ShowcaseException("Input showcase exception");
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<>(result, headers, HttpStatus.ACCEPTED);
	}

}
