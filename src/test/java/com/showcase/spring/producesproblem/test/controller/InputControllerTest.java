package com.showcase.spring.producesproblem.test.controller;

import com.showcase.spring.producesproblem.resource.InputResource;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InputControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(InputControllerTest.class);

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testSuccessfulPlain() throws Exception {
		initShowcaseTest(true, false);
	}

	@Test
	public void testErrorPlain() throws Exception {
		// FAILURE?? Should not be null
		initShowcaseTest(false, true);
	}

	@Test
	public void testErrorExplicitJsonUsingExplicitHeader() throws Exception {
		// FAILURE?? How should client know that he needs explicit error
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		initShowcaseTest(false, headers, false);
	}

	private void initShowcaseTest(boolean success, boolean shouldBeNull) {
		initShowcaseTest(success, null, shouldBeNull);
	}

	private void initShowcaseTest(boolean success, HttpHeaders headers, boolean shouldBeNull) {
		InputResource input = new InputResource();
		input.setInputValue("Should be successful");
		input.setSuccess(success);
		if (headers == null) {
			headers = new HttpHeaders();
		}
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<String> response = testRestTemplate.exchange(
				"/showcase", HttpMethod.POST, new HttpEntity<>(input, headers), String.class);

		logger.info("INPUT_CONTROLLER_TEST | response={}", response);

		if (shouldBeNull) {
			Assertions.assertThat(response.getBody()).isNull();
		} else {
			Assertions.assertThat(response.getBody()).isNotNull();
		}
	}
}
