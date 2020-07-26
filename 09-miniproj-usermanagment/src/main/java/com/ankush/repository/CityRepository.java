package com.ankush.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ankush.entity.CityEntity;


@Repository
public interface CityRepository extends JpaRepository<CityEntity, Serializable> {

	List<CityEntity> findAllByStateId(Integer stateId);

	
}
