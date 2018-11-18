package com.froad.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ZHUZIHUI
 * @date 2018年10月20日
 */
public class Blog implements Serializable {

	private static final long serialVersionUID = -1668144543945833423L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column
	private String title;

	@Column
	private String suject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSuject() {
		return suject;
	}

	public void setSuject(String suject) {
		this.suject = suject;
	}

}
