package com.ankush.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ankush.entity.CountryEntity;


@Repository
public interface CountryRepo extends JpaRepository<CountryEntity, Serializable> {

}
