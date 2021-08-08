package com.lessons.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 - Notice it is not public
  - Generally considered better to have things as private as possible
  - no modifier - aka - package-private
  - Is even more restrictive than protected
  - But remember in Java top level classes can only be public or default (no modifier)
  - Another good thing about this is less boilerplate
*/
class _10_AnatomyOfATest {

    /*
     - Notice no access modifier here too - same applies
    */
    @Test
    void myDumbTest() {
        Assertions.assertTrue(true);
    }

    /*
     - Assertions are static
     - So you can use static imports
     - You can find them at class: 'org.junit.jupiter.api.Assertions'
     */
    @Test
    void myDumbTest2() {
        assertTrue(true); // static import
    }

    void assertionWithAMessage() {
        assertEquals("Expected", "Actual", "Doh! The expected did not match the actual!");
    }

}
