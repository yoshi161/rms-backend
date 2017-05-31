package com.mitrais.bootcamp.rms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.mitrais.bootcamp.rms.data.entity.Employee;
import com.mitrais.bootcamp.rms.data.entity.FamilyMember;
import com.mitrais.bootcamp.rms.data.entity.Grade;
import com.mitrais.bootcamp.rms.data.entity.OfficeLocation;
import com.mitrais.bootcamp.rms.data.entity.Project;
import com.mitrais.bootcamp.rms.data.entity.refs.Division;
import com.mitrais.bootcamp.rms.data.entity.refs.JobFamily;
import com.mitrais.bootcamp.rms.data.entity.refs.OfficeAddress;
import com.mitrais.bootcamp.rms.data.entity.refs.SubDivision;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Employee.class)
        	.exposeIdsFor(JobFamily.class)
        	.exposeIdsFor(Division.class)
        	.exposeIdsFor(SubDivision.class)
        	.exposeIdsFor(Employee.class)
        	.exposeIdsFor(Grade.class)
        	.exposeIdsFor(FamilyMember.class)
        	.exposeIdsFor(OfficeLocation.class)
        	.exposeIdsFor(OfficeAddress.class)
        	.exposeIdsFor(Project.class);
    }
}
