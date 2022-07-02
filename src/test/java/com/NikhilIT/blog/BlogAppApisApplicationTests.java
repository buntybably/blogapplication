package com.NikhilIT.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.NikhilIT.blog.repository.UserRepository;

@SpringBootTest
class BlogAppApisApplicationTests {
	
	@Autowired
private UserRepository userRepository;
	@Test
	void contextLoads() {
	}
public void repoTest() {
	
	String classname = userRepository.getClass().getName();
	String packageName = userRepository.getClass().getPackageName();
	System.out.println(classname);
	System.out.println(packageName);
}
}
