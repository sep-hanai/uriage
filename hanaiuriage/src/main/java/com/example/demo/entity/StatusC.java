package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * 売上管理 Clientマスタ引用Entity
 * ステータスC
 */
@Data
@Entity
public class StatusC implements Serializable {
	/**
	 *
	 */
	private String clientid;

	/**
	 * ステータスID
	 */
	@Id
	private String statusid;

	/**
	 * ステータス名
	 */
	private String statusname;
}
