package com.emo.keyword;

import com.emo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author sherxia92
 * 2022/8/19 0019 下午 16:36
 */
@Slf4j
public class TransientDemo {

    private static String filePath = "E:\\Del\\transient\\user1.txt";

    @Test
    public static void writeObject() throws Exception {
        User user = new User();
        user.setUsername("sher");
        user.setPassword("123456");
        log.debug("user: {}", user);



        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
        os.writeObject(user);
        os.flush();
        os.close();
    }

    @Test
    public static void readObject() throws Exception {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
    }

    public static void main(String[] args) throws Exception {
        writeObject();
    }
}
