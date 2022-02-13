package io.Aniket.Liv2Train.Controllers;
import io.Aniket.Liv2Train.models.TrainingCenterModel;
import org.bson.Document;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import io.Aniket.Liv2Train.ExceptionsPkg.ExceptionClass;
import io.Aniket.Liv2Train.Repositories.TrainingCenterRepositories;
import io.Aniket.Liv2Train.TrainingCenterServices.TrainingCenterService;


@RestController
@RequestMapping("/centers")
public class TrainingCenterControllers {
	
	@Autowired
	private TrainingCenterRepositories repository;
	
	@Autowired
	private TrainingCenterService centerService;
	
	
	@GetMapping(value="/")
	public ResponseEntity<?> getAllCenters(){
		List<TrainingCenterModel> allCenters = repository.findAll();
		if (allCenters.size() > 0) {
			return new ResponseEntity<>(allCenters, HttpStatus.OK);
		}
		else if(allCenters.size() == 0) {
			return new ResponseEntity<>("No Training Center Data Found.", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Training Centers Found!", HttpStatus.NOT_FOUND);
		}
	}
	

	@PostMapping(value="/save-center")
	public ResponseEntity<?> saveCenterDetails(@RequestBody TrainingCenterModel CenterDetails) {
		try {
			centerService.createTrainingCenter(CenterDetails);
			return new ResponseEntity<>(CenterDetails, HttpStatus.CREATED);
		}
		catch (ConstraintViolationException ce) {
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (ExceptionClass ce) {
			return new ResponseEntity<>(ce.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping("/{CenterCode}")
	public ResponseEntity<?>  getCenterByCode(@PathVariable("CenterCode") String CenterCode) {
		Optional<TrainingCenterModel> centerDetails = repository.findByCenterCode(CenterCode);
		if (centerDetails.isPresent()) {
			return new ResponseEntity<>(centerDetails, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Center with the code " + CenterCode + " does not exist.", HttpStatus.NOT_FOUND);
		}

	}
}
