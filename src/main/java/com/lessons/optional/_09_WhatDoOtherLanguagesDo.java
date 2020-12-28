package com.lessons.optional;

/*
 - Some have library level support
     - Example Java Optional
 - Some have language level support
     - Example Kotlin
 - Some languages don't really have a concept of null and model the absence which a
   Maybe type (not that dissimilar to Optional)
     - Example Haskell
 - Some languages can perform 'sound null safety'
     - 'Sound' null safety offers more guarantees of null safety than the usual null
       safety such that the compiler can insert optimisations because it knows some
       variables can never be null
     - Example Dart
     - How is the 'soundness' achieved - with flow control analysis
     - e.g. in java I can call Optional.get() or just use any field that could be null
       and only get a runtime error
     - In dart it checks the flow control and knows if you have structured code such
       that a nullable will not be null before calling it
     - We will see an example later
*/
public class _09_WhatDoOtherLanguagesDo {
}
