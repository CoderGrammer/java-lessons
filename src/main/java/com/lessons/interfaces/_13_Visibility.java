package com.lessons.interfaces;

/*
 - Top level interfaces must be public or default
*/
public interface _13_Visibility {

    /*
     - Nested interfaces are public by default
     - Nested interfaces are static by default
     - Cannot have any other modifier
    */
    public static interface A { }

    /*
     - An interesting quirk...
     - 'protected' visibility is not allowed in interfaces
     - Deemed to offer little value for added complexity
    */
    interface LackingPrivacy {
        // protected String NAME = "CoderGrammer";
    }

    /*
     - By the way, what's the difference between protected and default (no access modifier)?
        - The difference is all about what subclasses in OTHER packages can access
            - default things cannot be accessed by subclasses in different packages
            - protected things can be accessed by subclasses in different packages
    */

}
