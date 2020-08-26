package com.unisource.universitysource.repository;

import com.unisource.universitysource.model.Tag;
import com.unisource.universitysource.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String name);

}
