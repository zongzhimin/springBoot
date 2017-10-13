package com.zzm.test.domain.mapper;

import java.util.List;

import com.zzm.test.domain.entity.UserEntity;

public interface UserMapper {
	List<UserEntity> getAll();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);

	void update(UserEntity user);

	void delete(Long id);
}	
