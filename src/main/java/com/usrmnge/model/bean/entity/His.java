package com.usrmnge.model.bean.entity;

import java.io.Serializable;
import java.security.acl.Owner;
import java.util.Date;

/**
 * @author lianmm
 * @version 0.1
 *
 */
public class His implements Serializable {

    private static final long serialVersionUID = 6872142563866152521L;
    private Integer id;
    private String owner;
    private String content;
    private Integer times;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTimes() {
        return times;
    }
    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
