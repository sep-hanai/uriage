package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * 売上管理 Entity
 */
@Entity
@Data
@Table(name="uriage")
public class Uriage implements Serializable{

}
