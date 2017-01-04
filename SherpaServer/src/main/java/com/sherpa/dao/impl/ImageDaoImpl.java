package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.ImageDao;
import com.sherpa.model.Image;

@Repository
public class ImageDaoImpl extends GenericDaoImpl<Image> implements ImageDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Image transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Image persistentInstance) {
		super.remove(persistentInstance);
	}

	@Override
	public Image merge(Image detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Image findById(Class<Image> clazz, long id) {
		return super.findById(clazz, id);
	}

}
