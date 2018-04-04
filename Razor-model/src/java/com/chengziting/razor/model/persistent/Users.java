package com.chengziting.razor.model.persistent;

import com.chengziting.razor.model.system.GUIDGenerator;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.*;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by user on 2018-01-16.
 */
@Entity
@Table(name = "users")
public class Users extends BaseModel{
    private String id;
    private String name;
    private String password;
    private String phone;
    private String email;
    private String qq;
    private int status;

    private List<Roles> roles;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = GUIDGenerator.GENERATOR_NAME)
    @Column(name = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "Name")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Password")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "Email")
    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "QQ")
    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Column(name = "Status")
    @NotNull
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userrole",
            joinColumns = {@JoinColumn(name = "UserId")},
            inverseJoinColumns = {@JoinColumn(name = "RoleId")})
    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
