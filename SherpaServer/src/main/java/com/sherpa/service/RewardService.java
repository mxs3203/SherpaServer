package com.sherpa.service;

import com.sherpa.dto.RewardDto;

public interface RewardService {

	RewardDto add(RewardDto transientInstance);

	void remove(long id);

	RewardDto update(RewardDto detachedInstance);

	RewardDto findById(long id);

}
