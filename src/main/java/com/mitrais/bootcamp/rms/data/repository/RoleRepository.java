package com.mitrais.bootcamp.rms.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mitrais.bootcamp.rms.data.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{


    @Query("SELECT r FROM Role r where lower(name) like %:name%")
    Role findByName(@Param("name") String name);

}
