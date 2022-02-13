package io.Aniket.Liv2Train.TrainingCenterServices;

import io.Aniket.Liv2Train.ExceptionsPkg.ExceptionClass;
import io.Aniket.Liv2Train.Repositories.TrainingCenterRepositories;
import io.Aniket.Liv2Train.models.TrainingCenterModel;

import java.util.Date;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {
	
	@Autowired
	TrainingCenterRepositories repository;

	@Override
	public void createTrainingCenter(TrainingCenterModel centerDetails) throws ConstraintViolationException, ExceptionClass {
		System.out.println(centerDetails.getCenterCode());
		Optional<TrainingCenterModel> center = repository.findByCenterCode(centerDetails.getCenterCode());
		System.out.println(center);
		
		if (center.isPresent()) {
			throw new ExceptionClass(ExceptionClass.AlreadyExistsException(centerDetails.getCenterCode()));
		}
		else {
			System.out.println(centerDetails.getCenterCode());
			centerDetails.setCreatedOn(new Date(System.currentTimeMillis()));
			repository.save(centerDetails);	
		}	
	}
}