package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StatusB;

/**
 * ステータスArepository
 *
 */
@Repository
public interface StatusBRepository extends JpaRepository <StatusB, Long>{
	@Query(value = "SELECT clientid, statusid, statusname FROM uriagemasta WHERE clientid=2 ORDER BY mastaid ASC", nativeQuery = true)
	List<StatusB> findAllOrderById();
}
