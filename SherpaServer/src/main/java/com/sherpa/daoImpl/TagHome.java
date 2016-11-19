package com.sherpa.daoImpl;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.Tag;

/**
 * Home object for domain model class Tag.
 * @see .Tag
 * @author Hibernate Tools
 */
@Stateless
public class TagHome {

	private static final Log log = LogFactory.getLog(TagHome.class);

	@PersistenceContext
	private EntityManager entityManager;

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

	public Tag findById(Integer id) {
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
}
