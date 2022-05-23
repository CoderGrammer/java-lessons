package com.lessons.misc;


public sealed class Animal permits Animal.Giraffe {

    static non-sealed class Giraffe extends Animal {
        String name;
        int age;
    }


}
