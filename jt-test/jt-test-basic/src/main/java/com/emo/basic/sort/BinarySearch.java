package com.emo.basic.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 二分查找
 * @author sherxia92
 */
@Slf4j
public class BinarySearch {
    static final int[] array = {13, 18, 24, 35, 47, 50, 62, 83, 90, 115, 134};
    static int target = 90;

    public final static void binarySearch_01() {
        int[] array = {1, 5, 10, 20, 55, 30, 33, 23, 50, 80, 90, 4};
        int target = 33;

        Arrays.sort(array);
        // 二分查找一定是在有序的数组中查找
        log.debug("{}", array);

        int result = Arrays.binarySearch(array, 55);
        log.debug("result: {}", result);
    }

    public final static int binarySearch_02() {
        int compareTimes = 0;
        int l = 0, r = array.length-1, m;
        while (l <= r) {
            compareTimes++;
            m = (l + r) >>> 1;
            if (array[m] == target) {
                log.debug("compareTimes: {}", compareTimes);
                return m;
            } else if (array[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        BinarySearch.binarySearch_01();
        int index = BinarySearch.binarySearch_02();
        log.debug("result index: {}, value: {}", index, array[index]);
    }
}
