package com.pbi.map.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbi.map.entity.SalaEntity;

@Repository
public interface SalaDAO extends JpaRepository<SalaEntity, Integer> {
	
}
