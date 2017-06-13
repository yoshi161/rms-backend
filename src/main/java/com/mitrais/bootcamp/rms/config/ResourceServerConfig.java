package com.mitrais.bootcamp.rms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private String httpAccessScope(String ...scopes) {
        StringBuilder scopeAccess = new StringBuilder();
        for(int i = 0; i < scopes.length; i++) {
            scopeAccess.append("#oauth2.hasScope('"+ scopes[i] +"')");

            if(i < (scopes.length - 1)) {
                scopeAccess.append(" or ");
            }
        }

        return String.valueOf(scopeAccess);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
    	final String ROLE_ADMIN = "ADMIN";
    	
        http.cors().and()
       // .addFilterBefore(corsFilter, WebConfig.class)
        .authorizeRequests()
        		.and().csrf().disable()
        		.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/roles").authenticated()
                .antMatchers(HttpMethod.GET, "/employees").authenticated()
                .antMatchers(HttpMethod.GET, "/employees/*").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
                .antMatchers(HttpMethod.GET, "/employees/*").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
                .antMatchers(HttpMethod.GET, "/employees/*/*").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE_DETAIL"))
                .antMatchers(HttpMethod.POST, "/employees").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
               // .antMatchers(HttpMethod.POST, "/employees/**").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
                .antMatchers(HttpMethod.PUT, "/employees/**").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST, "/employees/**").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.PATCH, "/employees/**").hasRole(ROLE_ADMIN)
                .anyRequest().fullyAuthenticated();

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("rms-resource");
    }
}
