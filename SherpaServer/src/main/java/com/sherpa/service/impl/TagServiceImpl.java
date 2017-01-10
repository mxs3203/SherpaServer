package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.TagDao;
import com.sherpa.model.Tag;
import com.sherpa.service.TagService;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;

	@Override
	public void add(Tag transientInstance) {
		tagDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		tagDao.remove(Tag.class, id);
	}

	@Override
	public Tag update(Tag detachedInstance) {
		return tagDao.merge(detachedInstance);
	}

	@Override
	public Tag findById(long id) {
		return tagDao.findById(Tag.class, id);
	}

}
