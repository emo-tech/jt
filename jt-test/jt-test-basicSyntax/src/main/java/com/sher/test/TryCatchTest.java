package com.sher.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author sherxia92
 */
@Slf4j
public class TryCatchTest {

    public static void tryCatchTest01() {
        try {
            log.debug("this is try !");
            int a = 1/0;
        } catch (Exception e) {
            log.debug("this is catch !");
            log.error("", e);
        } finally {
            log.debug("this is finally !");
        }
    }

    public static String tryCatchTest02() {
        try {
            log.debug("this is try !");
            return "return in try";
        } catch (Exception e) {
            log.debug("this is catch !");
            log.error("", e);
        } finally {
            log.debug("this is finally !");
        }
        return "return in function end";
    }


    @Test
    public void test() {
//        tryCatchTest01();
        log.debug("tryCatchTest02 return: [{}]", tryCatchTest02());
    }
}
