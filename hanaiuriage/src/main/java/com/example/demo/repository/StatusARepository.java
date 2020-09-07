package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StatusA;

/**
 * ステータスArepository
 *
 */
@Repository
public interface StatusARepository extends JpaRepository <StatusA, Long>{
	@Query(value = "SELECT clientid, statusid, statusname FROM uriagemasta WHERE clientid=1 ORDER BY mastaid ASC", nativeQuery = true)
	List<StatusA> findAllOrderById();
}
