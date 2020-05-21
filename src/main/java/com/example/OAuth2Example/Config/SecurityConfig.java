/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.OAuth2Example.Config;

import com.example.OAuth2Example.DAO.UserRepository;
import com.example.OAuth2Example.Entities.User;
import java.util.Map;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Artur
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                mvcMatchers("/").permitAll().anyRequest().authenticated()
                .and().csrf().disable();
    }
    
    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository){
        return (map)->{
            String id=(String) map.get("sub");
            User user=userRepository.findById(id).orElseGet(() ->{
                User newUser=new User();
                newUser.setId((String)map.get("sub"));
                newUser.setName((String)map.get("name"));
                newUser.setEmail((String)map.get("email"));
                newUser.setUserpic((String)map.get("picture"));
                newUser=userRepository.save(newUser);
                return newUser;
            });
            return user;
        };
    }
    
}
