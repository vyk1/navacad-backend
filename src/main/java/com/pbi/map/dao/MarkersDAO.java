package com.pbi.map.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pbi.map.entity.MarkersEntity;

@Repository
public interface MarkersDAO extends JpaRepository<MarkersEntity, Integer> {
	
}
