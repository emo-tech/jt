package com.sher.basic.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author sherxia92
 */
@Slf4j
public class BubbleSort {

    static int[] arrayOriginal = {5, 10, 20, 55, 33, 23, 50, 80, 4, 90};

    /**
     * 交换
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 未经优化
     */
    @Test
    public static void binarySearch_01() {
        int[] array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        log.debug("当前数组: [{}], 长度: [{}]", array, array.length);
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
                log.debug("内存循环比较第[{}]次排序", j);
            }
            log.debug("执行外层第[{}]次排序, 并且结果为[{}]", i, array);
        }
        log.debug("result: [{}]", array);
    }

    @Test
    public static void binarySearch_02() {
        int[] array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        log.debug("当前数组: [{}], 长度: [{}]", array, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                }
                log.debug("内存循环比较第[{}]次排序", j);
            }
            log.debug("执行外层第[{}]次排序, 并且结果为[{}]", i, array);
        }
        log.debug("result: [{}]", array);
    }

    @Test
    public static void binarySearch_03() {
        int[] array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        log.debug("当前数组: [{}], 长度: [{}]", array, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    swapped = true;
                }
                log.debug("内存循环比较第[{}]次排序", j);
            }
            if (!swapped) {
                break;
            }
            log.debug("执行外层第[{}]次排序, 并且结果为[{}]", i, array);
        }
        log.debug("result: [{}]", array);
    }

    @Test
    public static void binarySearch_04() {
        int[] array = Arrays.copyOf(arrayOriginal, arrayOriginal.length);
        log.debug("当前数组: [{}], 长度: [{}]", array, array.length);
        int lastSwapIndex = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            int currentLastSwapIndex = lastSwapIndex;
            for (int j = 0; j < currentLastSwapIndex; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    swapped = true;
                    lastSwapIndex = j;
                }
                log.debug("内存循环比较第[{}]次排序", j);
            }
            if (!swapped) {
                break;
            }
            log.debug("执行外层第[{}]次排序, 并且结果为[{}]", i, array);
        }
        log.debug("result: [{}]", array);
    }

    @Test
    public void run() {
        log.debug("\n\nbinarySearch_01====================");
        binarySearch_01();
        log.debug("\n\nbinarySearch_02====================");
        binarySearch_02();
        log.debug("\n\nbinarySearch_03====================");
        binarySearch_03();
        log.debug("\n\nbinarySearch_04====================");
        binarySearch_04();

    }
}
