package com.sherpa.RESTService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sherpa.dto.User;

@Path("/users")
public class UserResource {

	@GET
	// @Produces(MediaType.APPLICATION_JSON)
	public String users() {
		// UserHome uh = new UserHome();
		// User user = uh.findById(10);

		// return "branko";
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		User uh = session.get(User.class, 13);
		return uh.toString();

	}
}
