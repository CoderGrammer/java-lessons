package com.lessons.optional;

public class _40_WrapUp {

    /*
     - Intro
         - Null has been a big problem in Java
         - Optional provides a limited solution
         - Null the concept not bad it is a fact
         - e.g. person.getPetName() where the person has no pet
         - null references on the other hand are considered by many to be a huge mistake
         - Since they can appear in place of any object
         - And you either have checks all over the place or risk NPEs
         - null is a literal in Java
         - It has a special type but not one you can use
         - Despite this null is not an Object
         - You cannot call any of the methods of Object on it
         - null does not usually indicate a performance problem as there is only
           effectively one
         - null is not an instanceof anything including null
         - null == null in java
         - You can call static methods on a reference that points to null
         - You cannot synchronize on a null
         - Collections are inconsistent on nulls so you need to check
         - The new factory methods e.g. List.of do not permit nulls
     - Details
         - nulls are not stored on the heap
         - primitives cannot be null
         - Instance references default to null
         - Member references do not default to null
     - Design
         - If null can appear in your application, you need to be clear on what it
           signifies: e.g. uninitialized, missing or some special state...
         - Probably better to code for it with Optional
     - Optional
         - Mainly intended as a return type
         - Has two states; present and empty
         - Use factory methods to construct
         - ofNullable() is there to allow interacting with legacy systems
         - Its final and immutable
         - It does not store null
         - Its a value based class so identity functions (e.g. ==) should be avoided
     - When not to use
         - Should not be used when returning:
            - container types
            - collections
         - Should not be used as:
            - Field types in a bean class
            - To represent internal class state
            - As arguments to a method
            - As constructor arguments
            - As returns from getters
            - To replace 'if' statements
            - As elements in a collection
            - As generic types
          - Overuse - be careful with memory if you have collections of lots of Optionals
     - Usage
         - if you call 'get' call 'isPresent' first
         - But there is usually a better option
         - ifPresent
             - run some code if it is present
         - ifPresentOrElse
             - run some code if present or alternate code if not
         - isPresent and isEmpty:
             - Can be used for checks
         - ors
             - or
                - return the Optional if present or another Optional
             - orElse
                - return the value or another value (even null)
             - orElseGet
                - same as orElse except it should be used for expensive operations
             - orElseThrow
                - return the value or throw an exception if empty
         - map
             - transform the value if it is present
             - always returns an optional
         - flatMap
             - use this instead of map when your function yields an Optional
             - flatMap does not then wrap it in another Optional
         - Both flatMap and map return an Optional
         - filter
             - checks on a condition on an Optional if present
             - returns empty Optional if not present
         - Optionals have many methods in common with Streams
             - i.e. of, map, filter, flatMap
         - You can even convert an Optional to a Stream
          - the stream() method allows you to treat an Optional as a stream
          - so you can call the stream methods
          - but its often used with another streams flatMap method
          - e.g. cars
                    .stream()
                    .map(Car::getSunroof)
                    .flatMap(Optional::stream)
          - Specialized Streams
             - Optional/Double/LongOptional are mainly for return from numeric streams
             - You can return them from your methods
             - But they don't have all the methods on Optional
             - Optional has more methods but then your value will also be wrapped in an
               Wrapper so you need to consider your use case
         -

    */

}
