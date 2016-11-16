package com.sherpa.RESTService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/users")
public class UserResource{

    @GET
    @Produces("text/plain")
    public String users(){

        return "Branko";

    }
}
