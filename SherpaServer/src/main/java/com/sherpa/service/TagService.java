package com.sherpa.service;

import com.sherpa.dto.Tag;

public interface TagService {

	void addTag(Tag transientInstance);

	void removeTag(Tag persistentInstance);

	Tag updateTag(Tag detachedInstance);

	Tag findById(Long id);

}
