package com.sherpa.service;

import com.sherpa.dto.TagDto;

public interface TagService {

	void add(TagDto transientInstance);

	void remove(long id);

	TagDto update(TagDto detachedInstance);

	TagDto findById(long id);

}
