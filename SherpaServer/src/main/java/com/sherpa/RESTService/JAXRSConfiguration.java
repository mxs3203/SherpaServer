package com.sherpa.RESTService;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Root resource (exposed at "helloworld" path)
 */
@ApplicationPath("rest")
public class JAXRSConfiguration extends Application {

	/**
	 * Retrieves representation of an instance of helloWorld.HelloWorld
	 * 
	 * @return an instance of java.lang.String
	 */
	// @GET
	// @Produces("text/html")
	// public String getHtml() {
	// return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
	// }

	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(UserResource.class);
		return s;
	}
}