package com.lessons.optional;

import static com.lessons.optional._99_Utils.print;

public class _04_NullBasicsDefaultValues {

    /*
     - Java Memory
         - Stack
            - For memory allocation and thread execution
            - Primitives, references to objects
         - Heap
            - Objects
     - For all reference types the default value is null
     - Reference types (on the stack) contain a pointer to the memory location of the
       object on the heap
     - Primitives (on the stack) (instead of containing a pointer) contain the actual
       value
     - Primitives get a 'sensible' default but the default for references is null
     - This is not the same as uninitialized in a local var but you will get a compile
       error if you try to use it
    */

    /*
     - Instance Object variables
     - null is the default value for all object types
    */
    String t;
    Integer g;
    void instanceVarsObjects() {
        print(t); // prints null
        print(g); // prints null
    }

    /*
     - Instance primitive variables
         - Default to sensible defaults
         - They cannot be null!
    */
    int j;
    void instanceVarsPrimitives() {
        print(j);
    }

    /*
     - Static Object variables
        - Statics are class scoped so can't be declared in a method
        - The same initialization properties as instance variables
        - Default to null
    */
    static String s;
    void staticObjects() {
        print(s);
    }

    /*
     - Static primitive variables
        - Default to a sensible defaults, like instance variables
    */
    static int o;
    void staticPrimitives() {
        print(o);
    }

    /*
     - Member Object variables
         - Member variables are not initialized automatically
         - You must initialize before use
         - These are uninitialized NOT null
    */
    void memberVarsObjects() {
        Object f;
        // print(f.toString()); // Compile error
    }

    /*
     - Member primitive variables
        - Just like with objects these are uninitialized (not null)
    */
    void memberVarsPrimitives() {
        int q;
        // print(q); // Compile error
        // int y = null; // Compile error
    }

    /*
     - Member Object Variables Set to Null
         - Not really useful for our discussion as they do not default to null
    */
    void memberVarsObjectsNull() {
        Object o = null;
    }

    /*
     - Member primitive Variables Set to Null
         - Not really useful for our discussion as they do not default to null
    */
    void memberVarsPrimitivesNull() {
        // int g = null; // Compile error!
    }

    /*
     - Questions:
         - 1. Which type of memory are Objects stored in?
         - 2. Which type of memory are primitives stored in?
         - 3. Which type of memory are object references stored in?
         - 4. What is the default value of Object reference instance variables?
         - 5. What is the default value of Object reference variables in methods?
         - 6. What is the default value of primitive instance variables?
         - 7. What is the default value of primitive variables in methods?
         - 8. What is the default value of static Object reference variables?
         - 9. What is the default value of static primitive variables?
         - 10. Do method variables get a default value?
         - 11. Does using an uninitialized variable cause a runtime error?
         - 12. Can an uninitialized method variable ever compile?
         - Scroll down for answers
    */










    /*
     - Answers:
         - 1. Which type of memory are Objects stored in?
             - Heap
         - 2. Which type of memory are primitives stored in?
             - Stack
         - 3. Which type of memory are object references stored in?
             - Stack
         - 4. What is the default value of Object reference instance variables?
             - null
         - 5. What is the default value of Object reference variables in methods?
             - Method variables don't get a default value
         - 6. What is the default value of primitive instance variables?
             - A sensible default e.g. 0 for int, false for boolean etc
         - 7. What is the default value of primitive variables in methods?
             - Method variables don't get a default value
         - 8. What is the default value of static Object reference variables?
             - null, just like non-static instance variables
         - 9. What is the default value of static primitive variables?
             - a sensible default, just like with non-static instance variables
         - 10. Do method variables get a default value?
             - no, never
         - 11. Does using an uninitialized variable cause a runtime error?
             - no, it causes a compile time error
         - 12. Can an uninitialized method variable ever compile?
             - yes, as long as you initialize them before use
    */

}
