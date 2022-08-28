package com.emo.basic.set;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author sherxia92
 */
@Slf4j
public class LinkedHashSetTest {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("sher");
        hashSet.add("sherlock");
        hashSet.add("sage");
        hashSet.add("xia");
        hashSet.add("xie");
        log.debug("hashSet: {}", hashSet);


        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("sher");
        linkedHashSet.add("sherlock");
        linkedHashSet.add("sage");
        linkedHashSet.add("xia");
        linkedHashSet.add("xie");
        log.debug("linkedHashSet: {}", linkedHashSet);
    }

}
