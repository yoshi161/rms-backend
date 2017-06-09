package com.mitrais.bootcamp.rms.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mitrais.bootcamp.rms.data.entity.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {


    @Query("SELECT p FROM Privilege p where lower(name) like %:name%")
    Privilege findByName(@Param("name") String name);
}
