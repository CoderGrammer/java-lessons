package com.lessons.collections;

import io.vavr.collection.List;

/*
 - Persistent Collections
 - The original collection is not modified
 - Any 'modification' results in another collection
 */
public class VavrPersistentCollections {

    public static void main(String[] args) {
        List<Integer> l = List.of(1, 2, 3);
        List<Integer> l2 = l.append(4);
        System.out.println(l);
        System.out.println(l2);
    }

}
