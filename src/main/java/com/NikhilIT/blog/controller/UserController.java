package com.NikhilIT.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NikhilIT.blog.payloads.ApiResponse;
import com.NikhilIT.blog.payloads.UserDto;
import com.NikhilIT.blog.service.UserServiceIMPL;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserServiceIMPL userServiceIMPL;
	@PostMapping("/createusers")
	public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto){
		
		UserDto createuserDto = userServiceIMPL.Createuser(userDto);
		System.out.println(createuserDto);
		return new ResponseEntity<UserDto>(createuserDto,HttpStatus.CREATED);
		
		
	}
	@PutMapping("/userId")
	public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updateuser = userServiceIMPL.Updateuser(userDto, userId);
		
		
		return  ResponseEntity.ok(updateuser);
		
	}
	@DeleteMapping("/userId")
	public ResponseEntity<UserDto>deletUser(@PathVariable("userId")Integer uid){
		userServiceIMPL.deletuser(uid);
		return new ResponseEntity(new ApiResponse("user deleted sucessfully",false),HttpStatus.OK);
		
	}

}
