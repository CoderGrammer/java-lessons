package com.lessons.optional;

/*
When not to use Optional?
    - Returning container types including collections etc
    - as field types in a class because it is not serializable
    - as params to a method (unless you know the callers have an optional)
    - To represent internal class state
    - in constructors
    - As return types their lifecycle is short and they can be garbage collected by hotspot quickly
    - To replace an 'if' statement
*/
import com.lessons.optional._100_Utils.SearchResultSet;

import java.util.List;
import java.util.Optional;

public class _7_WhenNotToUse {

    public static void main(String[] args) {
        // No need for an Optional here
        SearchResultSet search = search();
        // We can provide a convenient mapping method
        search.mapBestMatch(g -> g.withMileage(g.getMileage() + 1000));
    }

    static SearchResultSet search() {
        return new SearchResultSet();
    }

    // Empty list is fine
    static List<_100_Utils.Car> fetch() {
        return List.of();
    }

    class Animal {

        class Tail { }
        class Beak { }

        // One approach
        // But Optional is not Serializable
        // This violates the bean laws. Sometimes you have a requirement that your beans are 'proper' beans such as in
        // some web contexts so they can be deflated and inflated
        Optional<Tail> tail;

        // Another approach
        Beak beak;

        // Personally I don't like it!
        // "I think routinely using it as a return value for getters would definitely be over-use." Brian Goetz
        // Where present more objects polluting the heap
        // More verbose also on every getter!
        // May also cause issues with bean handlers
        // Could be useful to callers but more than likely annoying!
        public Optional<Tail> getTail() {
            return tail;
        }

        public Optional<Beak> getBeak() {
            return Optional.ofNullable(beak);
        }
    }

}
