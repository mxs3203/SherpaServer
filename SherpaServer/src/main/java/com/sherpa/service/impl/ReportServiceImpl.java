package com.sherpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sherpa.dao.ReportDao;
import com.sherpa.dto.ReportDto;
import com.sherpa.model.Report;
import com.sherpa.service.ReportService;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportDao;

	@Override
	public ReportDto add(ReportDto transientInstance) {
		return reportDao.persist(transientInstance.toModel()).toDto();
	}

	@Override
	public void remove(long id) {
		reportDao.remove(Report.class, id);
	}

	@Override
	public ReportDto update(ReportDto detachedInstance) {
		return reportDao.merge(detachedInstance.toModel()).toDto();
	}

	@Override
	public ReportDto findById(long id) {
		return reportDao.findById(Report.class, id).toDto();
	}
}
