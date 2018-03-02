package com.chengziting.razor.model.persistent;

import com.chengziting.razor.model.system.GUIDGenerator;
import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by user on 2018-01-05.
 */
@Entity
@Table(name = "roles")
public class Roles extends BaseModel {
    private String id;
    private String name;
    private int status;

    public void setId(String id){
        this.id = id;
    }
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = GUIDGenerator.GENERATOR_NAME)
    @Column(name = "Id")
    public String getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    @Column(name = "Name")
    @NotNull
    public String getName(){
        return name;
    }

    public void setStatus(int status){
        this.status = status;
    }
    @Column(name = "Status")
    public int getStatus(){
        return status;
    }
}
