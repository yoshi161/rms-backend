package com.mitrais.bootcamp.rms.data.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="privilege")
public class Privilege {
	
	@Id
    @Column(name="privilege_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	

    @Column(name="name", nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;
	

	public Privilege(String name) {
		super();
		this.name = name;
	}
	
	

	public Privilege() {
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
}
