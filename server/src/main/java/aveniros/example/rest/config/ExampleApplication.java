package aveniros.example.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aveniros.example.rest.api.TeamsResource;

public class ExampleApplication extends Application {
	
	private Set<Object> singletons;
	
	public ExampleApplication() {
		singletons = new HashSet<>();
		singletons.add(new TeamsResource());
	}

	@Override
	public Set<Object> getSingletons() {
		// TODO Auto-generated method stub
		return singletons;
	}
}
