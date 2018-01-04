package com.chengziting.razor.model.persistent;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by user on 2017-12-29.
 */
public class BaseModel {
    protected Date m_createDate;
    protected Date m_updateDate;

    public void setCreateDate(Date date){
        this.m_createDate = date;
    }
    @Column(name = "createdate")
    public Date getCreateDate(){
        return m_createDate;
    }
    public void setUpdateDate(Date date){
        this.m_updateDate = date;
    }
    public Date getUpdateDate(){
        return m_updateDate;
    }
}
