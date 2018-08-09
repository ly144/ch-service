package com.ch.models;

import java.io.Serializable;

public class UserBind implements Serializable {
    private Integer id;
    private String key;
    private String code;

    public UserBind() {
    }

    public UserBind(Integer id, String key, String code) {
        this.id = id;
        this.key = key;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserBind{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
