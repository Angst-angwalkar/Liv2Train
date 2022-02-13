package io.Aniket.Liv2Train.Controllers;
import io.Aniket.Liv2Train.models.TrainingCenterModel;
import org.bson.Document;

import java.util.Date;
import java.util.List;

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

import io.Aniket.Liv2Train.Repositories.TrainingCenterRepositories;


@RestController
@RequestMapping("/centers")
public class TrainingCenterControllers {
	
	@Autowired
	private TrainingCenterRepositories repository;
	
	@Autowired
	private MongoTemplate template;
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
	@GetMapping(value="/")
	public ResponseEntity<?> getAllCenters(){
		List<TrainingCenterModel> allCenters = repository.findAll();
		if (allCenters.size() > 0) {
			return new ResponseEntity<>(allCenters, HttpStatus.OK);
		}
		else if(allCenters.size() == 0) {
			return new ResponseEntity<>(allCenters, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("No Training Centers Found!", HttpStatus.NOT_FOUND);
		}
		
		
	}
	
//	@RequestMapping(value="/save-center", method=RequestMethod.POST)
	@PostMapping(value="/save-center")
	public ResponseEntity<?> saveCenterDetails(@RequestBody TrainingCenterModel CenterDetails) {
		try {
			System.out.println(CenterDetails.getCenterCode());
			CenterDetails.setCreatedOn(new Date(System.currentTimeMillis()));
			repository.save(CenterDetails);
			return new ResponseEntity<>(CenterDetails, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	@RequestMapping("/{CenterCode}")
	public ResponseEntity<?>  getCenterByCode(@PathVariable("CenterCode") String CenterCode) {
//		return repository.findByCenterCode(CenterCode);
		return new ResponseEntity<>(repository.findByCenterCode(CenterCode), HttpStatus.OK);
	}
}
