package org.xsaas.xstat.web.bo;

import java.io.Serializable;

public class RecycledInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2159816630517340268L;
	private String name =null;
	private Long id = null;
	private Integer type = null;
	
	public RecycledInfo() {
		super();
	}
	public RecycledInfo(String name, Long id, Integer type) {
		super();
		this.name = name;
		this.id = id;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
