package com.froad.entity;

/**
 * @author ZHUZIHUI
 * @date 2018年10月20日
 */
public class Blog {

	private Long id;
	private String name;
	private String content;

	public Blog() {
		super();
	}

	public Blog(Long id, String name, String content) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
