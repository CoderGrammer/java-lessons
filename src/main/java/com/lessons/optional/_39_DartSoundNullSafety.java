package com.lessons.optional;

/*
 - Dart (along with some other languages) have 'sound null safety'
     - 'Sound' null safety offers more guarantees of null safety than the usual null
       safety such that the compiler can insert optimisations because it knows some
       variables can never be null
     - Example Dart
     - How is the 'soundness' achieved - with flow control analysis
     - e.g. in java I can call Optional.get() or just use any field that could be null
       and only get a runtime error
     - In dart it checks the flow control and knows if you have structured code such
       that a nullable will not be null before calling it
         - Types are non-nullable by default
         - Just like Kotlin for example
         - If you declare variables as nullable it will force you to handle that
         - The difference with Dart is that it is sound and therefore does not need to
           perform runtime checks. Through control flow analysis of the entire codebase.
         - This means it can perform some optimizations knowing that a variable can
           never be null

*/
public class _39_DartSoundNullSafety {
}
