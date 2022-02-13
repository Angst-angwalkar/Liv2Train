package io.Aniket.Liv2Train.Repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import io.Aniket.Liv2Train.models.TrainingCenterModel;


@Repository
public interface TrainingCenterRepositories extends MongoRepository<TrainingCenterModel, String> {
	
	@Query("{'CenterCode': '?0'}")
	Optional<TrainingCenterModel> findByCenterCode(String CenterCode);
	
}

