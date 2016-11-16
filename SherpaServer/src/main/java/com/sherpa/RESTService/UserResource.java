package com.sherpa.RESTService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sherpa.dao.UserHome;
import com.sherpa.dto.User;


@Path("/users")
public class UserResource{

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User users(){
    	//UserHome uh = new UserHome();
    	//User user = uh.findById(10);

        return null;

    }
    
    public static void main (String[] args){
    	
    	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    	Session session = sessionFactory.getCurrentSession();
    	
    	session.beginTransaction();


    	User uh = session.get(User.class, 13);
    	System.out.println(uh);
    	
    	
    };
}
