package com.sherpa.dao.impl;
// default package

import java.util.List;
import java.util.Set;

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.UserDao;
import com.sherpa.dto.UserDto;
import com.sherpa.model.Event;
import com.sherpa.model.Rating;
import com.sherpa.model.User;

/**
 * Home object for domain model class User.
 * 
 * @see .User
 * @author Hibernate Tools
 */
@Repository
public class UserDaoImpl implements UserDao {

	private static final Log log = LogFactory.getLog(UserDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(User persistentInstance) {
		log.debug("removing User instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public User findById(long id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = entityManager.find(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public UserDto getUserByCredentials(String email, String password) {
		 
		try {
			Query query = entityManager.createQuery("FROM User u WHERE u.email = :email AND u.password = :password");
			query.setParameter("email", email);
			query.setParameter("password", password);
			User user = (User) query.getSingleResult();
			return user.generateDto();
		} catch(NoResultException nre) {
			return null;
		}
	}
	
	/* TODO! bez fetch by id */
	@Override
	public Set<Event> getUserEvents(long userId) {
		User user = this.findById(userId);
		return user.getEvents();
	}

	@Override
	public List<Rating> getSherpasByRating(String region) {

		try {
			
			/* TODO! Greska u bazi? da linkamo i rated_user_id column u tablicu ; GROUP BY rating_id? */
			
			Query query = entityManager.createQuery("FROM Rating r INNER JOIN FETCH r.event e INNER JOIN FETCH e.locationByStartLocationId l INNER JOIN FETCH e.user u WHERE l.region = :region AND u.isSherpa = 1 ORDER BY r.rating DESC", Rating.class);
						
			query.setParameter("region", region);
			
			@SuppressWarnings("unchecked")
			List<Rating> ratings = query.getResultList();
			
			for(Rating r : ratings) {
				User u = r.getUser();
				u.getEvents();
			}
			
			System.out.println(ratings.toString());
			
			return ratings;
						
		} catch(NoResultException nre) {
			return null;
		}
		
	}
}
