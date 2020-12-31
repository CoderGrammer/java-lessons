package com.lessons.optional;

/*
 - When not to use Optional?
    - Returning container types including collections etc
    - As field types in a bean class because it is not serializable
    - To represent internal class state
    - As params to a method (unless you know the callers have an optional)
    - As constructor arguments
    - Getters, although as return types their lifecycle is short and they can be garbage
      collected by hotspot quickly
    - To replace an 'if' statement
    - In generic types
    - As collection element types
*/

import com.lessons.optional._99_Utils.SearchResultSet;

import java.util.List;
import java.util.Optional;

public class _13_WhenNotToUse {

    public static void main(String[] args) {
    }

    /*
     - Returning container types
    */
    void returningContainerTypes() {
        // No need for an Optional here
        SearchResultSet search = search();
        // We can provide a convenient mapping method
        search.mapBestMatch(g -> g.withMileage(g.getMileage() + 1000));
    }

    static SearchResultSet search() {
        return new SearchResultSet();
    }

    /*
     - Retuning lists
    */
    static List<_99_Utils.Car> fetch() {
        return List.of();
    }

    /*
     - Fields
    */
    class Animal {

        class Tail { }
        class Beak { }

        /*
         - Representing internal state
        */

        /*
         - One approach
         - But Optional is not Serializable
         - This violates the bean laws. Sometimes you have a requirement that your beans
           are 'proper' beans such as in framework code
         - some web contexts so they can be deflated and inflated
        */
        Optional<Tail> tail;

        // Another approach
        Beak beak;

        /*
         - Personally I don't like it!
         - "I think routinely using it as a return value for getters would definitely be
           over-use." Brian Goetz
         - Where present more objects polluting the heap
         - More verbose also on every getter!
         - May also cause issues with bean handlers
         - Could be useful to callers but more than likely annoying!
        */
        public Optional<Tail> getTail() {
            return tail;
        }

        /*
         - Getter
        */
        public Optional<Beak> getBeak() {
            return Optional.ofNullable(beak);
        }
    }

    /*
     - Method arguments
    */
    void methodArguments(Optional<String> s, Optional<Integer> i) {
        // Forces your callers to wrap into an Optional
        // Forces you to unwrap or work with an Optional
        // You can use method overloading or var args
    }

    /*
     - Constructor arguments
     - Same issue as method arguments
    */
    class A {
        public A(Optional<String> s, Optional<Integer> i) { }
    }

    /*
     - Replacing 'if' statements
     - What's wrong with null?
    */
    String replacingIf(String s) {
        return Optional
                .ofNullable(s)
                .map(String::toUpperCase)
                .orElse( "NOTHING");
    }

    /*
     - Maybe easier to read
     - One less object (albeit short lived)
     - More in line with the Java creators intentions for Optional
    */
    String notReplacingIf(String s) {
        if (s == null) {
            return "NOTHING";
        }
        return s.toUpperCase();
    }

    /*
     - Avoid using Optionals in Generics it will just clutter things that are already
       complex
    */
    interface Pet<T> { }

    class Dog1 implements Pet<Optional<GeneralPetFood>> { }
    class Cat1 implements Pet<Optional<GeneralPetFood>> { }
    class Fish1 implements Pet<Optional<FishFood>> { }

    class Dog implements Pet<GeneralPetFood> { }
    class Cat implements Pet<GeneralPetFood> { }
    class Fish implements Pet<FishFood> { }

    class GeneralPetFood {}
    class FishFood {}

    /*
     - Avoid as collection element type
    */
    void collections() {
        // Bad
        List<Optional<String>> l;
        // Way better
        List<String> l1;
    }

    /*
     - Questions:
         - 1. Optional is recommended for optional method params? True/False
         - 2. Optional is recommended for use as a possibly null method return type?
           True/False
         - 3. Optional is recommended for use as an instance field? True/False
         - 4. Optional should be used to represent no search results? True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Optional is recommended for optional method params? True/False
             - False
         - 2. Optional is recommended for use as a possibly null method return type?
           True/False
             - True. That's exactly what its for
         - 3. Optional is recommended for use as an instance field? True/False
             - False. Its not so useful for instance state or bean properties as it is
               not serializable
         - 4. Optional should be used to represent no search results? True/False
             - False. Search results would normally be returned as a container object
               or a collection of some type. Both scenarios can perfectly well model the
               absence of results. No need for Optional here.
    */

}
