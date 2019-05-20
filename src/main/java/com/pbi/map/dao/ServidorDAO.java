package com.pbi.map.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbi.map.entity.ServidorEntity;

@Repository
public interface ServidorDAO extends JpaRepository<ServidorEntity, Integer> {
	
}
