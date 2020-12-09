package com.lessons.optional;

/*
 - Some languages can perform sound null safety
     - 'Sound' null safety offers more guarantees of null safety than the usual null safety such that the compiler can insert optimisations
     - Example Dart
     - How is the 'soundness' achieved - with flow control analysis
     - e.g. in java I can call Optional.get() or just use any field that could be null and only get a runtime error
     - In dart it checks the flow control and knows if you have structured code such that a nullable will not be null before calling it
     - We will see an example later
 - Some languages don't really have a concept of null and model the absence which a Maybe type (not that dissimilar to Optional)
     - Example Haskell
 - Some have language level support
     - Example Kotlin
 - Some have library level support
     - Example Java Optional
*/
public class _2_z_WhatDoOtherLanguagesDo {
}
