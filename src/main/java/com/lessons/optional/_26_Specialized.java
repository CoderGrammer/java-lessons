package com.lessons.optional;

import lombok.NoArgsConstructor;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.lessons.optional._99_Utils.print;

/*
 - In addition to Optional, Java provides specialized optional types for primitives:
     - OptionalInt
     - OptionalDouble
     - OptionalLong
 - The purpose of these is to mitigate the effect of boxing/unboxing which would be
   required with say Optional<Integer> (and you can't have Optional<int>)
     - Can be costly because there is a double wrapper effectively:
            - int -> Optional<Integer[int]>>
     - With large data sets with calculations on the data it can get expensive
 - Analogous to specialized streams IntStream, DoubleStream, LongStream
 - Analogous to specialized functional types IntSupplier, DoubleFunction etc
 - All the specialized types work well together e.g.
     - IntStream, IntUnaryOperator, OptionalInt
 - There are fewer specialized Optionals than primitives
     - There are 8 primitive types
     - There are only 3 Optional specializations
 - Why? To prevent an explosion of types and because these three handle most cases
     - byte, char and short can be handled as ints
     - There is nothing for boolean
     - Remember you can still do Optional<Boolean> (wrapper type)
 - Specialized optionals do not extend Optional
 - These optionals do not have all the methods of Optional
 - They're missing filter, map, flatMap, ofNullable... methods
*/
public class _26_Specialized {

    public static void main(String[] args) {
        new _26_Specialized().theConceptsOfOptionalsAreTheSame();
    }

    /*
     - Not parametric like Optional
     - You cannot declare generic types for primitives
     - They store the primitive so any calculations are done on the actual primitive
     - Unlike trying to calculate on boxed primitives which would be expensive
    */
    void oneBigDifference() {
        Optional<Integer> o; // Parameterized type
        OptionalInt i;       // Non-parameterized type
    }

    void withAndWithout() {
        // Without specialized optionals
        Optional<Integer> o = Stream.of(2, 4)
                .map(g -> g * 5)
                .findFirst();
        print(o);

        // With specialized optionals
        OptionalInt o2 = IntStream.of(2, 4)
                .map(g -> g * 5)
                .findFirst();
        print(o2);
    }

    /*
     - There is no Optional*.ofNullable()
    */
    void ofNullable() {

        Optional<Integer> o = Optional.ofNullable(1);

        // OptionalInt o = OptionalInt.ofNullable(null); // Nope ?

        OptionalInt o2 = OptionalInt.of(0);

        // If you have an int you don't need it
    }

    /*
     - If you need one for legacy code, its trivial to create your own
    */
    static OptionalInt ofNullable(Integer i) {
        return i == null ? OptionalInt.empty() : OptionalInt.of(i);
    }

    /*
     - If you already have an Integer you need to consider whether Optional<Integer>
       may be a better choice
    */

    Integer legacyMethod() {
        return 1;
    }

    class OptionalIntExample {

        /*
         - We get less fluency (map, flatMap etc...) but less overhead
        */
        void clientMethod() {
            OptionalInt in = calc();
            // No box penalties
            in.ifPresentOrElse(
                    g -> print(g * 2),
                    () -> print(1));
        }

        OptionalInt calc() {
            Integer in = legacyMethod();
            // One boxing penalty!
            return in == null ? OptionalInt.empty() : OptionalInt.of(in);
        }

    }

    class OptionalExample {

        /*
         - Here we get more fluency but a lot of overhead
        */
        void clientMethod() {
            Optional<Integer> in = calc();
            // Multiple box penalties
            Integer i = in
                    .map(k -> k * 10)
                    .flatMap(k -> Optional.of(k * 5))
                    .orElse(1);
            print(i);
        }

        Optional<Integer> calc() {
            Integer i = legacyMethod();
            // No box penalty, but an extra wrapper
            return Optional.ofNullable(i);
        }

    }

    /*
     - So what can we conclude about ofNullable()
         - If you convert an Integer to OptionalInt you will pay one box penalty
            - But no boxing penalties processing it
        - If you convert it to Optional<Integer> you pay no box penalty
            - But created an extra wrapper so both Optional and Integer are live objects
            - Also you will pay boxing penalties on any processing
        - So in conclusion:
             - Its up to you!
             - You could use OptionalInt to signal clients should just operate on the
               value outside of the optional wrapper and you pay the box penalty
             - You could use Optional<Integer> and not pay the box penalty but allow
               the possibility that client code may perform expensive boxing computations
               on the internal value (and the Integer will be alive a little longer
               than in the OptionalInt case).
    */

    /*
     - Nothing for boolean?
         - As there are only two values maybe the benefit would likely be smaller
         - You could potentially represent values as 0s and 1s and treat as ints
    */
    void booleans() {
        // No OptionalBoolean?
        Optional<Boolean> b = Stream.of(true, false).findFirst();
        // OptionalBoolean b1 = BooleanStream.of(true, false).findFirst();
    }

    void theConceptsOfOptionalsAreTheSame() {
        // Empty
        OptionalDouble a = IntStream.of()
                .average();
        print(a);

        // Present
        OptionalDouble average = IntStream.of(1, 2)
                .average();
        print(average);
    }

    /*
     - Convenience methods
     - ...but don't forget the dangers
    */
    void convenienceMethods() {
        // Unsafe!
        IntStream.of(1, 2)
                .average()
                .getAsDouble(); // Extract the value

        // Safe
        OptionalDouble average = IntStream.of(1, 2)
                .average();
        if (average.isPresent()) {
            print(average.getAsDouble());
        }

        // Safe
        IntStream.of(1, 2)
                .average()
                .ifPresent(_99_Utils::print);
    }

    /*
     - Why are methods like map missing?
         - According to Stuart Marks see https://stackoverflow
           .com/questions/23414903/operations-on-java-8-optional-values)
         - 'the intent is for whoever processes the return value to unbox it
           immediately'... 'and then deal with actual primitives from then on'
    */
    void missingMethods() {
        OptionalInt first = IntStream.of(0, 1).findFirst();
        int i = first.orElseThrow();
        print(i * 10);
    }

    @NoArgsConstructor
    static class Person {
        OptionalInt getBs() {
            return OptionalInt.empty();
        }
    }

    /*
     - Can a stream of some other type convert to Stream<OptionalInt>
    */
    void convert() {

        // Yes but its not as clean as if it were Optional
        Optional<OptionalInt> o1 = Stream.of(new Person(), new Person())
                .map(Person::getBs)
                .findFirst();

        OptionalInt o2 = Stream.of(new Person(), new Person())
                // But we are forced to get it or deal with absence!
                .mapToInt(f -> f.getBs().getAsInt())
                .findFirst();

        OptionalInt o3 = Stream.of(new Person(), new Person())
                // Much nicer
                .flatMapToInt(p -> p.getBs().stream())
                .findFirst();
    }

    /*
     - Should you return Optional* from your code?
         - Most of the time it will constrain the caller
         - However it will force callers to operate on the primitive and not deal with
           boxing inadvertently (although they could re-box if they are determined)
         - It also depends on whether you already have an Integer or an int
             - We looked at the considerations of this earlier
         - Optional* specializations are mainly useful in primitive streaming contexts
         - All in all the answer will always be 'it depends' on context
    */

    void usingWithAnotherOptional() {
        Optional<Integer> i = Optional.of(1);

        Optional<Integer> f = i.flatMap(this::methA);// Doable
        // Optional<Integer> f2 = i.flatMap(this::methB); // Not doable

        // You can map it however but the return type is different
        // So you still get a double box
        Optional<OptionalInt> f3 = i.map(this::methB);

        // You can flatMap it with stream() as we saw earlier
        OptionalInt first = i.stream().flatMapToInt(g -> methB(g).stream()).findFirst();
    }

    Optional<Integer> methA(int i) {
        return Optional.empty();
    }

    OptionalInt methB(int i) {
        return OptionalInt.empty();
    }

    /*
     - The only visible difference is the return type and the stream name
     - The OptionalInt really only kicks in at the end
    */
    void isItWorthIt() {
        // In a stream pipeline its not just the final return type
        // Its the intermediary types
        Optional<Integer> o1 = Stream.of(1, 2, 3)
                .filter(i -> i > 10)
                .filter(i -> i < 10)
                .map(i -> i * 2)
                .findFirst();

        // All the intermediary types here are different
        OptionalInt o2 = IntStream.of(1, 2, 3)
                .filter(i -> i > 10)
                .filter(i -> i < 10)
                .map(i -> i * 2)
                .findFirst();

        // So overall there is a lot less boxing going on in the second example

        /*
         - But there is only one OptionalInt at the end. So again is it worth it?
             - It is consistent IntStream -> IntUnaryOperator -> OptionalInt
             - There is a slight performance improvement
             - There is a more of a performance improvement if additional methods are
               used
        */
        IntStream.of(1, 2, 3)
                .findFirst()
                // The following operation can operate on an int
                .ifPresent(i -> System.out.println(i * 12));
    }

    void whatsTheDealWithMapEtc() {
        OptionalInt o = OptionalInt.of(1);

        // Doesn't exist
        // o.map(h -> h*2);

        // But you can map with stream
        IntUnaryOperator i = h -> h * 100;
        o.stream().map(i);

        // You cannot change the type
        // o.stream().map(g -> g * 5.6);

        // I lied! You can if you call the right method
        o.stream().mapToDouble(g -> g * 5.6);
        o.stream().mapToObj(String::valueOf);

        o.stream().flatMap(t -> IntStream.of(t-1, t+1, t+2));

        // But you cannot change the type
        // o.stream().flatMap(t -> Stream.of("1", "2"));

        // I lied again! You can if you call the right method
        o.stream().mapToObj(Integer::valueOf).flatMap(t -> Stream.of("1", "2"));
        // Or even:
        o.stream().boxed().flatMap(t -> Stream.of("1", "2"));
    }











    /*
     - Questions:
         - 1. Is it ever valid to write code that returns OptionalDouble?
         - 2. OptionalInt#getAsInt() method will return the value or 0 because int type
              fields default to 0 in java. True/False
         - 3. Calling findAny() on an IntStream will return an OptionalInt or an
              Optional if empty. True/False
         - 4. OptionalLong extends Optional so there is no duplication. True/False
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Is it ever valid to write code that returns OptionalDouble?
             - Yes but its appropriateness depends on context
         - 2. OptionalInt#getAsInt() method will return the value or 0 because int type
              fields default to 0 in java.
             - False. Just like optional OptionalInt can be empty in which case this
               method will throw an exception and should not be called without a call to
               isPresent first
         - 3. Calling findAny() on an IntStream will return an OptionalInt or an
              Optional if empty.
             - False. It always returns OptionalInt which could be 'present' or 'empty'
         - 4. OptionalLong extends Optional so there is no duplication.
             - False. Optional specializations do not extent Optional

    */

}
