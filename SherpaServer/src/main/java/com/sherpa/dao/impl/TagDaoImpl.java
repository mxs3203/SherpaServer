package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.TagDao;
import com.sherpa.model.Tag;

@Repository
public class TagDaoImpl implements TagDao {

	private static final Log log = LogFactory.getLog(TagDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Tag transientInstance) {
		log.debug("persisting Tag instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Override
	public void remove(Tag persistentInstance) {
		log.debug("removing Tag instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Override
	public Tag merge(Tag detachedInstance) {
		log.debug("merging Tag instance");
		try {
			Tag result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public Tag findById(long id) {
		log.debug("getting Tag instance with id: " + id);
		try {
			Tag instance = entityManager.find(Tag.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* TODO! Refactor */
	@Override
	public Tag findByTagName(String tagName) {
		log.debug("getting Tag instance with name: " + tagName);
		try {
			Query query = entityManager.createQuery("FROM Tag t WHERE t.tagName = :tagName");
			query.setParameter("tagName", tagName);
			return (Tag) query.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
