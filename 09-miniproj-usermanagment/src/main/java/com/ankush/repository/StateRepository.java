package com.ankush.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ankush.entity.StateEntity;


@Repository
public interface StateRepository extends JpaRepository<StateEntity, Serializable> {

	List<StateEntity> findAllByCountryId(Integer countryId);

}
