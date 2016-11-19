package com.sherpa.service;

import com.sherpa.dto.Report;

public interface RepostService {

	void addReport(Report transientInstance);

	void removeReport(Report persistentInstance);

	Report updateReport(Report detachedInstance);

	Report findById(Long id);

}
