package com.sherpa.service;

import com.sherpa.dto.TagDto;

public interface TagService {

	TagDto add(TagDto transientInstance);

	void remove(long id);

	TagDto update(TagDto detachedInstance);

	TagDto findById(long id);

}
