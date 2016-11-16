package com.sherpa.RESTService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
 
/**
 * Root resource (exposed at "helloworld" path)
 */
@ApplicationPath("rest")
public class JAXRSConfiguration extends Application{
   
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces("text/html")
//    public String getHtml() {
//        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
//    }
	
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(UserResource.class);
        return s;
    }
}