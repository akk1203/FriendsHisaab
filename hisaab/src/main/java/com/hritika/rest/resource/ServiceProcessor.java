package com.hritika.rest.resource;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.camel.Exchange;

public class ServiceProcessor {
	
	public void construct200OkResponse(Exchange exchange){
		exchange.getOut().setBody(
				constructResponse(exchange.getIn().getBody(), Status.OK));
	}
	
	public void construct500InternalError(Exchange exchange){
		exchange.getOut().setBody(
				constructResponse(exchange.getIn().getBody(), Status.INTERNAL_SERVER_ERROR));
	}
	
	public <T> Response constructResponse(T t, Status status){
		ResponseBuilder builder = Response.status(status);
		builder.entity(t);
		return builder.build();
	}

}
