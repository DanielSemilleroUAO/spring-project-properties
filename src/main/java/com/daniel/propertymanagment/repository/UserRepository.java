package com.daniel.propertymanagment.repository;

import com.daniel.propertymanagment.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByOwnerEmailAndPassword(String email, String password);

}
