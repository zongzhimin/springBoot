package com.zzm.test.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zzm.test.domain.entity.User;

public interface UserRepository extends MongoRepository<User,Long>{

	User findByUsername(String username);
}
