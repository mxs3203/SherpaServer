package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.TagDao;
import com.sherpa.model.Tag;

@Repository
public class TagDaoImpl extends GenericDaoImpl<Tag> implements TagDao {

	private static final Logger log = LoggerFactory.getLogger(TagDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Tag transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Tag persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public Tag merge(Tag detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Tag findById(Class<Tag> clazz, long id) {
		return super.findById(clazz, id);
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
