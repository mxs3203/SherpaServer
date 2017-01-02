package com.sherpa.daoImpl;
// default package

// Generated Nov 13, 2016 2:15:17 PM by Hibernate Tools 5.2.0.Beta1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.ImageDao;
import com.sherpa.model.Image;

/**
 * Home object for domain model class Image.
 * 
 * @see .Image
 * @author Hibernate Tools
 */
@Repository
public class ImageDaoImpl implements ImageDao {

	private static final Log log = LogFactory.getLog(ImageDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
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

	@Override
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

	@Override
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

	@Override
	public Image findById(long id) {
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
