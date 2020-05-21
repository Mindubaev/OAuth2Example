/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.OAuth2Example.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.userdetails.UserDetails;

@Entity()
@Table(name = "usr")
public class User{
    
    @Id
    private String id;
    private String name;
    private String userpic;
    private String email;

    public User(String id, String name, String userpic, String email) {
        this.id = id;
        this.name = name;
        this.userpic = userpic;
        this.email = email;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserpic() {
        return userpic;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
