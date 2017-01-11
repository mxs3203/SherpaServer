package com.sherpa.dao.impl;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.UserDao;
import com.sherpa.model.Event;
import com.sherpa.model.User;
import com.sherpa.util.Util;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	private static final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(User transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Class<User> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public User merge(User detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public User findById(Class<User> clazz, long id) {
		return super.findById(clazz, id);
	}

	@Override
	public User findByCredentials(User p_user) {
		log.debug("getting User instance with email: '{}' and password: '{}'", p_user.getEmail(), p_user.getPassword());
		try {
			Query query = entityManager.createQuery("FROM User u WHERE u.email = :email AND u.password = :password")
					.setParameter("email", p_user.getEmail()).setParameter("password", p_user.getEmail());

			log.debug("get successful");
			return (User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	@Override
	public Set<Event> getUserEvents(User p_user) {
		log.debug("getting Events for User instance with ID: {}", p_user.getUserId());
		try {
			Query query = entityManager.createQuery("FROM Event e WHERE e.userId = :userId").setParameter("userId",
					p_user.getUserId());

			log.debug("get successful");
			return Util.castSet(Event.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* TODO! Provjerit dal valja */
	@Override
	public Set<User> getSherpasByRatingInRegion(String region) {
		log.debug("getting Sherpa instances by Rating in Region: '{}'", region);
		try {
			Query query = entityManager
					.createQuery(
							"FROM Rating r INNER JOIN FETCH r.event e INNER JOIN FETCH e.locationByStartLocationId l INNER JOIN FETCH e.user u WHERE l.region = :region AND u.isSherpa = 1 ORDER BY r.rating DESC")
					.setParameter("region", region);

			log.debug("get successful");
			return Util.castSet(User.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
