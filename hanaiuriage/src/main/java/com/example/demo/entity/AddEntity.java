package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * 売上管理 マスタ引用Entity
 */
@Data
@Entity
public class AddEntity implements Serializable {
	/**
	 * マスタID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long mastaid;

	/**
	 * 顧客ID
	 */
	private String clientid;

	/**
	 * 顧客名
	 */
	private String clientname;

	/**
	 * ステータスID
	 */
	private String statusid;

	/**
	 * ステータス名
	 */
	private String statusname;

	/**
	 * 備考
	 */
	private String memo;
}
