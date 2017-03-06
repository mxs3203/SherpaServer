package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.TagDao;
import com.sherpa.dto.TagDto;
import com.sherpa.model.Tag;
import com.sherpa.service.TagService;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;

	@Override
	public TagDto add(TagDto transientInstance) {
		return tagDao.persist(transientInstance.toModel()).toDto();
	}

	@Override
	public void remove(long id) {
		tagDao.remove(Tag.class, id);
	}

	@Override
	public TagDto update(TagDto detachedInstance) {
		return tagDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public TagDto findById(long id) {
		return tagDao.findById(Tag.class, id).toDto();
	}

}
