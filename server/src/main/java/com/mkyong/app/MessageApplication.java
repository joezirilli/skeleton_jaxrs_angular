package com.mkyong.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.mkyong.rest.MessageRestService;
import com.mkyong.rest.StuffResource;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new MessageRestService());
		singletons.add(new StuffResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
