package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Uriage;

/**
 * 売上管理repository
 */
@Repository
public interface UriageRepository extends JpaRepository<Uriage, Long>{
	/**
	 * 全件取得
	 * 売上テーブル=u
	 * マスターテーブル=m
	 * @return
	 */
	@Query(value = "SELECT u.id as id, m.clientname as clientname, u.orderdate as orderdate, u.snumber as snumber, "
			+ "u.subject as subject, u.quantity as quantity, u.deadline as deadline, "
			+ "u.duedate as duedate, u.billingdate as billingdate, u.estimate as estimate, u.decision as decision,"
			+ " m.statusname as statusname, u.note as note, u.delete_flg as delete_flg "
			+ "from uriage u"
			+ " join uriagemasta m on m.clientid = u.clientid "
			+ "WHERE u.delete_flg=0 AND u.clientid=m.clientid AND u.statusid=m.statusid ORDER BY u.id", nativeQuery = true)
	List<Uriage> findAllOrderById();
}
