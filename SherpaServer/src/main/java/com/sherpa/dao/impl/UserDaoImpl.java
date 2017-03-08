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
	public User persist(User transientInstance) {
		return super.persist(transientInstance);
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
	public User findByCredentials(User user) {
		log.debug("getting User instance with email: '{}' and password: '{}'", user.getEmail(), user.getPassword());
		try {
			Query query = entityManager.createQuery("FROM User u WHERE u.email = :email AND u.password = :password")
					.setParameter("email", user.getEmail()).setParameter("password", user.getPassword());
			log.debug("get successful");
			return (User) query.getSingleResult();
		} catch (NoResultException nre) {
			log.error("get failed", nre);
			throw nre;
		}
	}

	@Override
	public Set<Event> getSherpaEvents(long id) {
		log.debug("getting Events for Sherpa instance with ID: {}", id);
		try {
			Query query = entityManager
					.createQuery(
							"FROM Event e WHERE e.user.userId = :userId AND e.user.isSherpa = true AND e.isFinished = false")
					.setParameter("userId", id);
			log.debug("get successful");
			return Util.castSet(Event.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Set<User> getUsersByRegion(String region) {
		log.debug("getting All User (Sherpa and non-Sherpa) instances in Region: {}", region);
		try {
			Query query = entityManager.createQuery("SELECT l.users FROM Location l WHERE l.region = :region")
					.setParameter("region", region);
			log.debug("get successful");
			return Util.castSet(User.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public Set<User> getSherpasByRegion(String region) {
		log.debug("getting Sherpa instances in Region: {}", region);
		try {
			Query query = entityManager
					.createQuery(
							"SELECT l.users FROM Location l JOIN l.users u WHERE l.region = :region AND u.isSherpa = true")
					.setParameter("region", region);
			log.debug("get successful");
			return Util.castSet(User.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/*
	 * TODO! Query ok? Query vrati X rezultata, a castList gleda dal taj objekt
	 * (u ovom slucaju User objekt) vec postoji u setu i ako postoji ne dodaje
	 * ga. E sad buduci da je rating kao sto veci to bolji, mozda bi ga trebao
	 * ostavit i mi to onda handle-at s nekim logikama? + order by ovdje nista
	 * ne radi jer set nema ordering
	 */
	@Override
	public Set<User> getSherpasByRatingInRegion(String region) {
		log.debug("getting Sherpa instances by Rating in Region: '{}'", region);
		try {
			Query query = entityManager
					.createQuery(
							"SELECT u FROM User u JOIN Rating r ON r.user.userId = u.userId JOIN Event e ON r.event.eventId = e.eventId JOIN Location l ON l.locationId = e.locationByStartLocationId WHERE u.isSherpa = true AND l.region = :region ORDER BY r.rating DESC")
					.setParameter("region", region);
			log.debug("get successful");
			return Util.castSet(User.class, query.getResultList());
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
