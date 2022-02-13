package io.Aniket.Liv2Train.TrainingCenterServices;

import javax.validation.ConstraintViolationException;

import io.Aniket.Liv2Train.ExceptionsPkg.ExceptionClass;
import io.Aniket.Liv2Train.models.TrainingCenterModel;

public interface TrainingCenterService {
	
	public void createTrainingCenter(TrainingCenterModel centerDetails) throws ConstraintViolationException, ExceptionClass;

}
