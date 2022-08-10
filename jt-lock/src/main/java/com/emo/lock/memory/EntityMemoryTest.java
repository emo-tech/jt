package com.emo.lock.memory;

import com.emo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author sherxia92
 * 2022/8/10 0010 上午 10:54
 */
@Slf4j
public class EntityMemoryTest {

    @Test
    public void test01() throws InterruptedException {
        User user = new User(1, "sher");
//        System.out.println(ClassLayout.parseInstance(user).toPrintable());

        synchronized(user) {
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
            Thread.sleep(12000);
            System.out.println(ClassLayout.parseInstance(user).toPrintable());
        }
    }
}
