package com.lessons.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class _54_Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.FIELD})
    public @interface SecretInfo {}

    @SecretInfo
    String creditCardNumber;

    /*
     - Annotations are using to decorate certain fields, methods etc.
     - We mention them because they are declared with @interface which could cause some
       confusion
     - Annotations are a form of interface but for simplicity it's probably best to just
       think of them as annotations
     - They are a whole topic on their own, and maybe we will cover them separately in
       future
    */

}
