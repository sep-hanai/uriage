package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StatusC;

/**
 * ステータスArepository
 *
 */
@Repository
public interface StatusCRepository extends JpaRepository <StatusC, Long>{
	@Query(value = "SELECT clientid, statusid, statusname FROM uriagemasta WHERE clientid=3 ORDER BY mastaid ASC", nativeQuery = true)
	List<StatusC> findAllOrderById();
}
