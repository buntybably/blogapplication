package com.NikhilIT.blog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NikhilIT.blog.entity.UserEntity;
import com.NikhilIT.blog.exception.ResourceNotFoundException;
import com.NikhilIT.blog.payloads.UserDto;
import com.NikhilIT.blog.repository.UserRepository;

@Service
public class UserServiceIMPL implements UserServiceI {
@Autowired
private UserRepository userRepository; 
	@Override
	public UserDto Createuser(UserDto userDto) {
		UserEntity user=this.dtotoUser(userDto);
		UserEntity save = userRepository.save(user);

		
		return this.UsertoDto(save);
	}

	@Override
	public UserDto Updateuser(UserDto userDto, Integer userID) {
		UserEntity user = userRepository.findById(userID).orElseThrow(()->new ResourceNotFoundException("User","ID",userID));
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		UserEntity updateuser = userRepository.save(user);
		UserDto userDto1=this.UsertoDto(updateuser);
		return userDto1;
	}
	@Override
	public List<UserDto> getAllUser() {
		List<UserEntity> list = userRepository.findAll();	
		
		List<UserDto> list2 = list.stream().map(user->this.UsertoDto(user)).collect(Collectors.toList());
		return list2;
	}
	@Override
	public UserDto getuserbyID(Integer userID) {
		UserEntity user = userRepository.findById(userID).orElseThrow(()->new ResourceNotFoundException("User","ID",userID));
		return this.UsertoDto(user);
	}
	@Override
	public void deletuser(Integer userID) {
		UserEntity user=userRepository.findById(userID).orElseThrow(()->new ResourceNotFoundException("User","ID",userID));
		this.userRepository.delete(user);
	}
	

	public UserEntity dtotoUser(UserDto userDto) {
		UserEntity user=new UserEntity();
		user.setId(user.getId());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		user.setName(user.getName());
		user.setAbout(user.getAbout());
		return user;
		
	}
	

	public UserDto UsertoDto(UserEntity user) {
		
		UserDto userDto=new UserDto();
		userDto.setId(userDto.getId());
		userDto.setName(userDto.getName());
		userDto.setEmail(userDto.getEmail());
		userDto.setPassword(userDto.getPassword());
		
		
		return userDto;

}

	

	


}




	

	



