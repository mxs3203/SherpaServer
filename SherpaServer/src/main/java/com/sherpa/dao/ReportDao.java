package com.sherpa.dao;

import com.sherpa.model.Report;

public interface ReportDao extends GenericDao<Report> {

	void persist(Report transientInstance);

	void remove(Report persistentInstance);

	Report merge(Report detachedInstance);

	Report findById(Class<Report> clazz, long id);

}
