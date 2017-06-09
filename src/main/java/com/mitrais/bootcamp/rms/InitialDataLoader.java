package com.mitrais.bootcamp.rms;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mitrais.bootcamp.rms.data.constanta.EmployeeStatus;
import com.mitrais.bootcamp.rms.data.constanta.Gender;
import com.mitrais.bootcamp.rms.data.entity.Employee;
import com.mitrais.bootcamp.rms.data.entity.Privilege;
import com.mitrais.bootcamp.rms.data.entity.Role;
import com.mitrais.bootcamp.rms.data.repository.EmployeeRepository;
import com.mitrais.bootcamp.rms.data.repository.PrivilegeRepository;
import com.mitrais.bootcamp.rms.data.repository.RoleRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	boolean alreadySetup = true;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup) return;
		
		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		
		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		List<Privilege> userPrivileges = Arrays.asList(readPrivilege);
		
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", userPrivileges);
		
	    Date d = new Date(1); // Intialize date with the string date
		
		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
		Employee employee = new Employee();
		employee.setFirstName("Don");
		employee.setLastName("Tomasino");
		employee.setUsername("dontomasino");
		employee.setPassword("$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri");
		employee.setGender(Gender.Male);
		employee.setPhone("+62772");
		employee.setEmail("dontomasino@gmail.com");
		employee.setJobFamily("JOB");
		employee.setDateAdded(new java.sql.Timestamp(d.getTime()));
		employee.setLastModified(new java.sql.Timestamp(d.getTime()));
		employee.setHiredDate(d);
		employee.setEmpStatus(EmployeeStatus.Contract);
		employee.setRoles(Arrays.asList(adminRole));
		employeeRepository.save(employee);
		
		alreadySetup = true;
		
	}
	
	@Transactional
	private Privilege createPrivilegeIfNotFound(String name) {
		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}
	
	private Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = new Role(name);
			role.setPrivileges(privileges);
			roleRepository.save(role);
		}
		return role;
	}

}
