package com.example.controller;

import com.example.MyUserDetailsService;
import com.example.DAO.UserService;
import com.example.model.AuthenticationRequest;
import com.example.model.AuthenticationResponse;
import com.example.model.UserModel;
import com.example.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/user/signup")
    public void saveUser(@RequestBody UserModel user){
        System.out.println("Signup");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
    }


    @PostMapping(value={"/user/login"})
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("In authenticate");
		try {
            System.out.println("Inside try");
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
            System.out.println("End of try");
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
        }
        catch(Exception e){
            System.out.println(e);
        }
		


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
        System.out.println(jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
    
}
