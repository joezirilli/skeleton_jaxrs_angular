package com.mkyong.rest;

import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stuff")
public class StuffResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<String> getStuff() {
		return Arrays.asList("stuff", "things", "other things");
	}
}
