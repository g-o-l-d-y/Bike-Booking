package com.example;

import com.example.DAO.UserRepo;
import com.example.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1 =new User();

		UserModel user=userRepo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("404!!!!!");
        else
        {
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            user1.setRole(user.getUserRole());
        }
        return new UserPrincipal(user1);
	}

}
