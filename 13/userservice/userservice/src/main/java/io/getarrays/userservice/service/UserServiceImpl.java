/**
 * 
 */
package io.getarrays.userservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.repo.RoleRepo;
import io.getarrays.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ASUS 30-Dec-20219:20:55 pm
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService,UserDetailsService {

	private final UserRepo userRepo;

	private final RoleRepo roleRepo;
	 private final PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user=userRepo.findByUserName(username);
		if(user== null)
		{
			log.error("User not found in the datbase");
			throw new UsernameNotFoundException("User not found in the datbase");
		}
		else {
			log.info("User found in the datbase:{}",username);
		}
		
		Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
		user.getRoles()
            .forEach(role->{
            	authorities.add( new SimpleGrantedAuthority(role.getName()));
            	});		
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		log.info("Saving new user{} to database",user.getName());
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		log.info("Saving new role{} to database",role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		log.info("Adding role {} to user {}",roleName,username);
		User user = userRepo.findByUserName(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		log.info("fetching user{}",username);
		return userRepo.findByUserName(username);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		log.info("fetching all users");
		return userRepo.findAll();
	}

	

}
