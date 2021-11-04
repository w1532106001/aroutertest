package com.whc.lib_annotations;

import java.io.Serializable;

public class User2 implements Serializable {
    private String username;
    private int age;

    public User2() {
    }

    public User2(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
