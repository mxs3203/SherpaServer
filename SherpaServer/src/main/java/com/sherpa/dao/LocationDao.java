package com.sherpa.dao;

import com.sherpa.dto.Location;

public interface LocationDao {

	Location findById(int locId);
	
}
