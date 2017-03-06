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
	public Image persist(Image transientInstance) {
		return super.persist(transientInstance);
	}

	@Override
	public void remove(Class<Image> clazz, long id) {
		super.remove(clazz, id);
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
