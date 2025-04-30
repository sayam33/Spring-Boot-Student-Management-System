package com.demo.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Branch {
	@Id
	private long id;
	
	private String branch;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
}