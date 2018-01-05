package com.chengziting.razor.model.persistent;

import com.sun.istack.internal.NotNull;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by user on 2018-01-05.
 */
@Table(name = "roles")
public class Roles extends BaseModel {
    private int m_id;
    private String m_name;
    private int m_status;

    public void setId(int id){
        m_id = id;
    }
    @Id
    @Column(name = "Id")
    public int getId(){
        return m_id;
    }

    public void setName(String name){
        m_name = name;
    }
    @Column(name = "Name")
    @NotNull
    public String getName(){
        return m_name;
    }

    public void setStatus(int status){
        m_status = status;
    }
    @Column(name = "Status")
    public int getStatus(){
        return m_status;
    }
}
