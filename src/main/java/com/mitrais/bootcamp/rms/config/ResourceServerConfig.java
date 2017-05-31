package com.mitrais.bootcamp.rms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
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
        http.cors().and()
       // .addFilterBefore(corsFilter, WebConfig.class)
        .authorizeRequests()
        		.and().csrf().disable()
        		.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/employees").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
                .antMatchers(HttpMethod.GET, "/employees/*").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
                .antMatchers(HttpMethod.GET, "/employees/*").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
                .antMatchers(HttpMethod.GET, "/employees/*/*").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE_DETAIL"))
                .antMatchers(HttpMethod.POST, "/employees").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"))
                .antMatchers(HttpMethod.POST, "/employees/**").access(httpAccessScope("ROOT", "ROOT_EMPLOYEE", "READ_EMPLOYEE"));

    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("rms-resource");
    }
}
