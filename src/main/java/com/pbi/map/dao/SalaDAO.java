package com.pbi.map.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pbi.map.entity.SalaEntity;

@Repository
public interface SalaDAO extends JpaRepository<SalaEntity, Integer> {
	@Query("SELECT obj FROM SalaEntity obj WHERE obj.nome LIKE %:nome%")
	List<SalaEntity> search(@Param("nome") String nome);
	
}
