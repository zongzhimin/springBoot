package com.zzm.test.domain.entity;

import java.io.Serializable;

public class UserEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userSex;
	private String nickName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public UserEntity() {
		super();
	}
	public UserEntity(String userSex, String nickName) {
		super();
		this.userSex = userSex;
		this.nickName = nickName;
	}
	
}	
