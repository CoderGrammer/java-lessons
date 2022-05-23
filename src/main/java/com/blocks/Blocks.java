package com.blocks;

public class Blocks {

    static {
        System.out.println("static 1");
    }

    {
        System.out.println("instance");
    }

    static {
        System.out.println("static 2");
    }

    Blocks() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        Blocks b = new Blocks();
        blah : {
            System.out.println("blah");
            if (1 == 1) {
                break blah;
            }
            System.out.println("foo");
        }
    }

}
