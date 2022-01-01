/**
 * 
 */
package io.getarrays.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;

/**
 * @author ASUS
 *30-Dec-20219:14:04 pm
 */


public interface UserService {

	
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser (String username);
	List<User> getUsers();
}
