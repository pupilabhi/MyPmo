package com.connectivity.vikray.service;


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
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(cp);
		} else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}
	
	public ValidResult getAllPhase() {
		result.setData(PhaseServiceImpl.getAllPhase());
		result.setErrorCode((long) 101);
		result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
		return result;
	}

	public ValidResult updatePhase(Phase phase) {
		Object rt= PhaseServiceImpl.updatePhase(phase);
		if (rt != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(rt);
		}else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}

	public ValidResult getPhasesByProjectId(Long projectId) {
		Object rt= PhaseServiceImpl.getPhasesByProjectId(projectId);
		if (rt != null) {
			result.setErrorCode((long) 101);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
			result.setData(rt);
		}else {
			result.setErrorCode((long) 102);
			result.setErrorMsg(VikrayPmoMessageConstant.KEY_102);
		}
		return result;
	}
}
