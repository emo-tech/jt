package com.emo.basic.calc;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 */
@Slf4j
public class PowerCalc {

    /**
     * 查找数字是n的几次幂
     * @param value
     * @return
     */
    public static String toBinary(int value) {
        char[] buf = new char[32];
        int charPos = 32;
        int mask = 1;
        do {
            int index = value & mask;
//            buf[--charPos] = digits[index];
            value >>>= 1;
        } while (value != 0);
        return new String(buf, charPos, (32-charPos));
    }

    public static int cal2Power(int n) {
        int result = 1;
        int calcTime = 0;
        while (calcTime < n) {
            result = result*2;
            calcTime++;
        }
        return result;
    }

    public static void main(String[] args) {
        log.debug("{}", cal2Power(1));
        log.debug("{}", cal2Power(2));
        log.debug("{}", cal2Power(31));

        log.debug("{}", 2147483647 + 1);
        log.debug("{}", 2147483647 * 2 -1);
    }
}
