package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;

@Service
public class ServiceImpl implements IUserService, UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Integer saveUser(User user) {
		String pwd = encoder.encode(user.getPassword());
		return repo.save(user).getId();
	}

	@Override
	public User findByUsername(String username) {
		Optional<User> opt = repo.findByUsername(username);
		if (opt.isPresent())
			return opt.get();

		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByUsername(username);
		if (null == user) 
			throw new UserNotFoundException(username + " not exist");

		List<GrantedAuthority> list = 
		user.getRoles().stream().map(
				role -> new SimpleGrantedAuthority(role))		
				.collect(Collectors.toList());
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), list);
	}
}
