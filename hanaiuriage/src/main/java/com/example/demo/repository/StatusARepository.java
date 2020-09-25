package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StatusA;

/**
 * ステータスArepository
 */
@Repository
public interface StatusARepository extends JpaRepository <StatusA, Long>{
	@Query(value = "SELECT mastaid, clientid, clientname, statusid, statusname FROM uriagemasta ORDER BY statusid ASC", nativeQuery = true)
	List<StatusA> findAllOrderById();

	@Query(value = "SELECT mastaid, clientid, clientname, statusid, statusname FROM uriagemasta WHERE clientid LIKE :clientid AND statusid LIKE :statusid", nativeQuery  = true)
	List<StatusA> findByName(@Param("clientid") String clientid, @Param("statusid") String statusid);

}
