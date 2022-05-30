package com.blocks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
 - You can catch exceptions in a code block just like a constructor
 - And the same in static initializers
 - However, you can't throw them from a code block, but you can from a constructor
*/
public class _05_BlocksExceptionInConstructor {

    final int i;

    {
        i = Integer.parseInt("1");
        File file = new File("");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static {
        File file = new File("");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    _05_BlocksExceptionInConstructor() {
        File file = new File("");
        try {
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new _05_BlocksExceptionInConstructor();
    }

}
