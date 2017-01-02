package com.sherpa.dao;

import com.sherpa.model.Report;

public interface ReportDao {

	void persist(Report transientInstance);

	void remove(Report persistentInstance);

	Report merge(Report detachedInstance);

	Report findById(long id);

}
