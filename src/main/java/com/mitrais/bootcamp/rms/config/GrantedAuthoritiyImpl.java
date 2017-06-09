package com.mitrais.bootcamp.rms.config;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthoritiyImpl implements GrantedAuthority {
	
	private String authority;
	
	public GrantedAuthoritiyImpl(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
