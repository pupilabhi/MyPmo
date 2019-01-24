/*package com.connectivity.vikray.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connectivity.vikray.constant.VikrayPmoMessageConstant;
import com.connectivity.vikray.entity.Phase;
import com.connectivity.vikray.pojo.ValidResult;
import com.connectivity.vikray.serviceImpl.PhaseServiceImpl;
import com.connectivity.vikray.serviceImpl.ProjectServiceImpl;


@Service("PhaseService")
public interface PhaseService {
	
	@Autowired
	ProjectServiceImpl projectServiceImpl;
	
	@Autowired
	ValidResult result;
	
	public ValidResult createPhase(Phase phase) {
		Object cp= PhaseServiceImpl.createPhase(phase);
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
}
*/