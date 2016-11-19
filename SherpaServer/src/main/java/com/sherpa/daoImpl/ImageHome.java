package com.sherpa.daoImpl;
// default package
// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sherpa.dto.Image;

/**
 * Home object for domain model class Image.
 * @see .Image
 * @author Hibernate Tools
 */
@Stateless
public class ImageHome {

	private static final Log log = LogFactory.getLog(ImageHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Image transientInstance) {
		log.debug("persisting Image instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Image persistentInstance) {
		log.debug("removing Image instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Image merge(Image detachedInstance) {
		log.debug("merging Image instance");
		try {
			Image result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Image findById(Integer id) {
		log.debug("getting Image instance with id: " + id);
		try {
			Image instance = entityManager.find(Image.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
