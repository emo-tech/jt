package com.emo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @author sherxia92
 * 2022/8/10 0010 上午 10:43
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;

    private String username;
    private transient String password;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
