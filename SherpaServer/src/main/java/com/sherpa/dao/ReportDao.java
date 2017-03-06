package com.sherpa.dao;

import com.sherpa.model.Report;

public interface ReportDao extends GenericDao<Report> {

	Report persist(Report transientInstance);

	void remove(Class<Report> clazz, long id);

	Report merge(Report detachedInstance);

	Report findById(Class<Report> clazz, long id);

}
