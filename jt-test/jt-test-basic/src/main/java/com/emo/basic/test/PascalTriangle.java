package com.emo.basic.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sherxia92
 *              1
 *            1   1
 *           1  2  1
 *         1  3   3   1
 *       1  4   6   4   1
 *     1  5  10  10   5   1
 */
@Slf4j
public class PascalTriangle{

    public static int f(int m, int n) {
        if(m==0) {
            return 1;
        }
        if(n==0 || n==m) {
            return 1;
        }
        return f(m-1, n-1) + f(m-1, n);
    }

    public static void main(String[] args) {
        for (int m = 0; m < 6; m++) {
            for (int n = 0; n <= m; n++) {
                log.debug("{}", f(m, n));
            }
            log.debug("--------------");
        }
    }
}
