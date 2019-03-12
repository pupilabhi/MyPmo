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
	PhaseServiceImpl phaseServiceImpl;
	
	@Autowired
	ValidResult result;
	
	public ValidResult createPhase(Phase phase) {
			Phase cp= phaseServiceImpl.createPhase(phase);
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
		result.setData(phaseServiceImpl.getAllPhase());
		result.setErrorCode((long) 101);
		result.setErrorMsg(VikrayPmoMessageConstant.KEY_101);
		return result;
	}

	public ValidResult updatePhase(Phase phase) {
		Object rt= phaseServiceImpl.updatePhase(phase);
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
		Object rt= phaseServiceImpl.getPhasesByProjectId(projectId);
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

	public ValidResult getPhaseById(Long id) {
		Object rt= phaseServiceImpl.getPhaseById(id);
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
