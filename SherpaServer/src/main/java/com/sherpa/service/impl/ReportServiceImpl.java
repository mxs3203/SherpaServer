package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ReportDao;
import com.sherpa.model.Report;
import com.sherpa.service.ReportService;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportDao;

	@Override
	public void add(Report transientInstance) {
		reportDao.persist(transientInstance);
	}

	@Override
	public void remove(long id) {
		reportDao.remove(Report.class, id);
	}

	@Override
	public Report update(Report detachedInstance) {
		return reportDao.merge(detachedInstance);
	}

	@Override
	public Report findById(long id) {
		return reportDao.findById(Report.class, id);
	}
}
