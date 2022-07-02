package com.NikhilIT.blog.service;

import java.util.List;

import com.NikhilIT.blog.payloads.UserDto;

public interface UserServiceI {
	UserDto Createuser(UserDto user);
	UserDto Updateuser(UserDto user, Integer userID);
	UserDto getuserbyID(Integer userID );
	List<UserDto>getAllUser();
	void deletuser(Integer userID);



}
