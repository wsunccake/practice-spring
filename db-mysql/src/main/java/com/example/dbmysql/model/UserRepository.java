package com.example.dbmysql.model;

import org.springframework.data.repository.CrudRepository;


// auto implement CRUD
public interface UserRepository extends CrudRepository<User, Integer> {
}
