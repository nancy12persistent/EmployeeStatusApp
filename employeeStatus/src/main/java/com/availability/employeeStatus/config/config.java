package com.availability.employeeStatus.config;
  
import org.springframework.context.annotation.Bean; 
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.springframework.security.crypto.password.NoOpPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
  
@SuppressWarnings("deprecation")
@EnableWebSecurity
public class config extends WebSecurityConfigurerAdapter {
	
	// Adding the roles 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
        auth.inMemoryAuthentication() 
                .withUser("Zack") 
                .password("aayush") 
                .roles("admin_role") 
                .and() 
                .withUser("GFG") 
                .password("Helloword") 
                .roles("student"); 
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
        http. 
                httpBasic() 
                .and() 
                .authorizeRequests() 
                .antMatchers("/employees/save").hasRole("admin_role") 
                .antMatchers("/employees/updateStatus/**").hasRole("admin_role") 
                .antMatchers("/employees/update/**").hasRole("admin_role")
                .antMatchers("/employees/getemployee").hasAnyRole("admin_role","student")
                .antMatchers("/employees/employeename/**").hasAnyRole("admin_role","student")
                .antMatchers("/employees/status/**").hasAnyRole("admin_role","student")
                .and() 
                .formLogin(); 
                http.csrf().disable();
    } 
  
    // Function to encode the password 
    // assign to the particular roles. 
    @Bean
    public PasswordEncoder getPasswordEncoder(){ 
        return NoOpPasswordEncoder.getInstance(); 
    }	

}
