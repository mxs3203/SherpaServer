package com.sherpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.sherpa.dao.ReportDao;
import com.sherpa.model.Report;

@Repository
public class ReportDaoImpl extends GenericDaoImpl<Report> implements ReportDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Report transientInstance) {
		super.persist(transientInstance);
	}

	@Override
	public void remove(Class<Report> clazz, long id) {
		super.remove(clazz, id);
	}

	@Override
	public Report merge(Report detachedInstance) {
		return super.merge(detachedInstance);
	}

	@Override
	public Report findById(Class<Report> clazz, long id) {
		return super.findById(clazz, id);
	}

}
