package com.lessons.optional;

import static com.lessons.optional._99_Utils.print;

/*
 - What is it?
     - “…a limited mechanism for library meth return types...”
 - Why do we need it?
     - Because NPEs are very annoying and can be costly
*/
public class _03_WhyOptional {

    public static void main(String[] args) {

        // Annoying
        String s = null;
        print(s.length());

        // More annoying when calling an external method
        print(meth().length());
    }

    static String meth() {
        return null;
    }

}
