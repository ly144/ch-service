package com.ch.models;

import java.io.Serializable;

public class Result implements Serializable {
    private boolean success;
    private int root;
    private String picture;

    public Result() {
    }

    public Result(boolean success, String picture) {
        this.success = success;
        this.picture = picture;
    }

    public Result(boolean success, int root, String picture) {
        this.success = success;
        this.root = root;
        this.picture = picture;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
