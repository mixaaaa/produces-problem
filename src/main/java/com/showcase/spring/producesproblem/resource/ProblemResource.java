package com.showcase.spring.producesproblem.resource;

public class ProblemResource {

	private String errMsg;

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("ProblemResource [");
		sb.append("errMsg='").append(errMsg).append('\'');
		sb.append(']');
		return sb.toString();
	}
}
