package com.showcase.spring.producesproblem.resource;

public class InputResource {

	private String inputValue;

	private Boolean success;

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("InputResource [");
		sb.append("inputValue='").append(inputValue).append('\'');
		sb.append(", success=").append(success);
		sb.append(']');
		return sb.toString();
	}
}
