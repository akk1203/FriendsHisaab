package com.hritika.model;

public class Response {
	
	private InvocationOutcome invocationOutcome;
	private String _id;
	
	public InvocationOutcome getInvocationOutcome() {
		return invocationOutcome;
	}
	
	public void setInvocationOutcome(InvocationOutcome invocationOutcome) {
		this.invocationOutcome = invocationOutcome;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
