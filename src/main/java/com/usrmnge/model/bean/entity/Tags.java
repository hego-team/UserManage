package com.usrmnge.model.bean.entity;

import java.io.Serializable;
import java.security.acl.Owner;
import java.util.Date;

/**
 * @author lianmm
 * @version 0.1
 *
 */
public class Tags implements Serializable {

    private static final long serialVersionUID = 6872142563866152521L;
    private Integer id;
    private String owner;
    private String name;
    private String url;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
