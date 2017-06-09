package com.mitrais.bootcamp.rms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitrais.bootcamp.rms.data.entity.Employee;
import com.mitrais.bootcamp.rms.data.entity.Privilege;
import com.mitrais.bootcamp.rms.data.entity.Role;
import com.mitrais.bootcamp.rms.data.repository.EmployeeRepository;
import com.mitrais.bootcamp.rms.data.repository.RoleRepository;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByusername(username);
        employee.setGrantedAuthorities(getAuthorities(employee.getRoles()));
        return employee;
    }
 
    private Collection<? extends GrantedAuthority> getAuthorities(
      Collection<Role> roles) {
    	return getGrantedAuthorities(getPrivileges(roles), roles);
    }
    

    private List<String> getPrivileges(Collection<Role> roles) {
  
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges, Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        
        for (Role role : roles) {
        	authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }
}
