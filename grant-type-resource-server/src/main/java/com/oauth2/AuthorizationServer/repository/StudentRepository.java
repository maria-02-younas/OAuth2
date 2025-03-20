package com.oauth2.AuthorizationServer.repository;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.oauth2.AuthorizationServer.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students")
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
