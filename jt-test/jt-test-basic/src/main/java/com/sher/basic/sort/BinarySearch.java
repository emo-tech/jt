package com.sher.basic.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 二分查找
 * @author sherxia92
 */
@Slf4j
public class BinarySearch {

    @Test
    public void binarySearch_01() {
        int[] array = {1, 5, 10, 20, 55, 30, 33, 23, 50, 80, 90, 4};
        int target = 33;

        Arrays.sort(array);
        // 二分查找一定是在有序的数组中查找
        log.debug("{}", array);
    }
}
