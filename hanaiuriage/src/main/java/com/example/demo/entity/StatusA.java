package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * 売上管理 Clientマスタ引用Entity
 * ステータスA
 */
@Data
@Entity
public class StatusA implements Serializable {
	/**
	 * マスタID
	 */
	@Id
	private Long mastaid;

	/**
	 *顧客ID
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
}
