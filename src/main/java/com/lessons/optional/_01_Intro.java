package com.lessons.optional;

/*
 - Welcome to this course on Java Optional and null
     - Why a lengthy course?
        - NPEs have been a real pain for Java devs for years!
        - null references described as 'The Billion Dollar Mistake'
        - Incredible amount of dev time wasted trying to prevent NPEs and checking for
          them
     - Optional since JDK8 is here to address issues around handling null references
     - Can be difficult to trace the real source of the problem
     - Often much confusion about the best way to handle them from endless null checks to
       setting default values, confusion around primitives/objects
     - In my experience there is little consistency in the way null is handled in most
       apps
     - Optional is often used and abused in almost every PR/MR
     - The problem/solution are so ubiquitous that sub-optimal use adds up over time
     - Its important to get the design approach right
     - We will go into a lot of detail
 - About this course:
     - We use Java 11 and later touch on Java 14
     - What are we going to cover?
     - We will ask questions at the end of some chapters to check your understanding
     - By the end of course you should be confident:
         - Understanding the concept of null
         - In considering the best design approach for null in your application
         - In using Optional in a sensible way and making best use of its features
*/
public class _01_Intro { }
