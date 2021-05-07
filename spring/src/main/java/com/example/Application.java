package com.example;

import com.example.DAO.BikeRepo;
import com.example.DAO.UserRepo;
import com.example.filters.JwtRequestFilter;
import com.example.model.BikeModel;
import com.example.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@SpringBootApplication
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	UserRepo userRepo;

	@Autowired
	BikeRepo bikeRepo;
	
	public void run(String... args) throws Exception{
		this.userRepo.save(new UserModel("goldy","$2a$04$lMsTrF.mIRMpH8RMfAhkJ.UOu9qVslYzuWdyeSu3ZaQ9LdWaSlHpi","goldy@gmail.com","1234567890",20,"ROLE_USER"));
		this.userRepo.save(new UserModel("richard","$2a$04$lMsTrF.mIRMpH8RMfAhkJ.UOu9qVslYzuWdyeSu3ZaQ9LdWaSlHpi","rich@gmail.com","3434343434",23,"ROLE_SUPERADMIN"));
		this.userRepo.save(new UserModel("reymond","$2a$04$lMsTrF.mIRMpH8RMfAhkJ.UOu9qVslYzuWdyeSu3ZaQ9LdWaSlHpi","rey@gmail.com","4545454545",34,"ROLE_ADMIN"));
		this.bikeRepo.save(new BikeModel("1234","reymond","notBooked","90000"));
	}
}



@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
			.cors().and()
				.authorizeRequests().antMatchers("/user/login","/user/signup").permitAll().
				antMatchers("/user/dashboard","/user/bikes","/user/bookBike","/user/editProfile","/user/bikeDetails","/user/bookings","/user/profile").hasRole("USER").
				antMatchers("/admin/profile","/admin/editProfile","/admin/addBike","/admin/editBike","/admin/deleteBike","/admin/dashboard","/user/bikeDetails").hasRole("ADMIN").
				antMatchers("/superadmin/dashboard","/superadmin/deleteUser").hasRole("SUPERADMIN").and().authorizeRequests()
						.anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
	}

	@Bean
    CorsConfigurationSource corsConfigurationSource() 
    {
        CorsConfiguration configuration = new CorsConfiguration();
        //configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200","http://localhost:8080"));
        //configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        configuration.applyPermitDefaultValues();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }

}
