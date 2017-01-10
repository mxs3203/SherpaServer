package com.sherpa.service;

import com.sherpa.model.Report;

public interface ReportService {

	void add(Report transientInstance);

	void remove(long id);

	Report update(Report detachedInstance);

	Report findById(long id);

}
