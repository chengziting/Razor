package com.chengziting.razor.model.persistent;

import com.chengziting.razor.model.system.GUIDGenerator;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by user on 2018-03-02.
 */
@Entity
@Table(name = "userrole")
public class UserRole extends BaseModel{
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = GUIDGenerator.GENERATOR_NAME)
    @Column(name = "Id")
    private String id;

    @NotNull
    @JoinColumn(name = "UserId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;
    @NotNull
    @JoinColumn(name = "RoleId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Roles role;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
