package com.sherpa.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.TagDao;
import com.sherpa.dto.Tag;
import com.sherpa.service.TagService;

@Service
@Transactional
public class TagServiceImpl implements TagService {

	@Autowired
    private TagDao tagDao;

	@Override
	public void addTag(Tag transientInstance) {
		tagDao.persist(transientInstance);
	}
	
	@Override
	public void removeTag(Tag persistentInstance) {
		tagDao.remove(persistentInstance);
	}
	
	@Override
	public Tag updateTag(Tag detachedInstance) {
		return tagDao.merge(detachedInstance);
	}
	
	@Override
	public Tag findById(Long id) {
		return tagDao.findById(id);
	}
	
}
