package com.connectivity.vikray.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.PhaseServiceImpl;

@Service("PhaseService")
public class PhaseService {

	@Autowired
	PhaseServiceImpl PhaseServiceImpl;
	
	@Autowired
	ValidResult result;
	
	public ValidResult createPhase(Phase phase) {
			Phase cp= PhaseServiceImpl.createPhase(phase);
		if (cp != null) {
			result.ErrorCode = (long) 101;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
			result.data = cp;
		} else {
			result.ErrorCode = (long) 102;
			result.ErrorMsg = VikrayPmoMessageConstant.KEY_102;
		}
		return result;
	}
	
	public ValidResult getAllPhase() {
		result.data = PhaseServiceImpl.getAllPhase();
		result.ErrorCode = (long) 101;
		result.ErrorMsg = VikrayPmoMessageConstant.KEY_101;
		return result;
	}

	public ValidResult updatePhase(Phase phase) {
		Object rt= PhaseServiceImpl.updatePhase(phase);
		if (rt != null) {
			result.ErrorCode= (long) 101;
			result.ErrorMsg= VikrayPmoMessageConstant.KEY_101;
			result.data= rt;
		}else {
			result.ErrorCode= (long) 102;
			result.ErrorMsg= VikrayPmoMessageConstant.KEY_102;
		}
		return result;
	}
}
