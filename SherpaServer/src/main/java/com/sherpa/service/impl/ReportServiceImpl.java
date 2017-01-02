package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ReportDao;
import com.sherpa.model.Report;
import com.sherpa.service.RepostService;

@Service
@Transactional
public class ReportServiceImpl implements RepostService {

	@Autowired
    private ReportDao reportDao;

	@Override
	public void addReport(Report transientInstance) {
		reportDao.persist(transientInstance);
	}
	
	@Override
	public void removeReport(Report persistentInstance) {
		reportDao.remove(persistentInstance);
	}
	
	@Override
	public Report updateReport(Report detachedInstance) {
		return reportDao.merge(detachedInstance);
	}
	
	@Override
	public Report findById(long id) {
		return reportDao.findById(id);
	}
}
