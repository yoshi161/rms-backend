package com.mitrais.bootcamp.rms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.bootcamp.rms.service.EmployeeService;

@RestController
public class Security {
	
	@Autowired
	private EmployeeService employeeService;

    @RequestMapping("/roles")
    public List<String> index() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName(); //get logged in username
        UserDetails employee = employeeService.loadUserByUsername(username);
        List<String> authorities = new ArrayList<String>();
        for (GrantedAuthority authority : employee.getAuthorities()) {
        	authorities.add(authority.getAuthority());
        }
        return authorities;
    }

}
