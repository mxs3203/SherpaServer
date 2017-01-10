package com.sherpa.service;

import com.sherpa.model.Tag;

public interface TagService {

	void add(Tag transientInstance);

	void remove(long id);

	Tag update(Tag detachedInstance);

	Tag findById(long id);

}
