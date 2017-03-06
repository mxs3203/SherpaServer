package com.sherpa.service;

import com.sherpa.dto.ReportDto;

public interface ReportService {

	ReportDto add(ReportDto transientInstance);

	void remove(long id);

	ReportDto update(ReportDto detachedInstance);

	ReportDto findById(long id);

}
