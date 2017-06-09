package com.mitrais.bootcamp.rms.data.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	
	@Id
    @Column(name="role_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

    @Column(name="name", nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<Employee> employees;
	
	
    public Role() {
	}

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "roles_privileges", 
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "role_id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "privilege_id"))
	private Collection<Privilege> privileges;
    
	public Role(String name) {
		super();
		this.name = name;
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

	public Collection<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Collection<Employee> employees) {
		this.employees = employees;
	}

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	

}
