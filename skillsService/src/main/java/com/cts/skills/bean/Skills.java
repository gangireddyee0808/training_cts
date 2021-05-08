package com.cts.skills.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="skills_details")
public class Skills {
	
	@Id
	@Column(name="skill_id")
	private Long id;
	@NotBlank(message="Name cannot be blank")
	private String name;
	@NotBlank(message="Description cannot be blank")
	private String descr;
	@NotBlank(message="level cannot be blank")
	private String level;
	@NotNull
	private Long user_id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	

}
