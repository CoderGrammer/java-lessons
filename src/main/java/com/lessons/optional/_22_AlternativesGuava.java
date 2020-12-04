package com.lessons.optional;

import com.google.common.base.Optional;

/*
 - Led to Javas Optional
 - One of the key differences is that this is Serializable
 - Java deliberately did not make Optional serializable
 - ...this is because in Project Valhalla introduces value types
 - Value types do not have identity but Serialized objects have identity
 - Serialization inherently depends on identity
 - JDK rules require back and forward compaitibility across releases
 - Missing useful methods like flatMap, stream, filter...
 - Guava recommend you use the Java version
 - May be deprecated at some point
 - The lead of Guava was on the expert group for java
*/
public class _22_AlternativesGuava {

    public static void main(String[] args) {

        // Similar construction
        Optional<String> o1 = Optional.of("abc");
        // Convert to Javas Optional
        java.util.Optional<String> s = o1.toJavaUtil();
        // Convert from Javas Optional
        Optional<String> o2 = Optional.fromJavaUtil(java.util.Optional.of("abc"));

        // absent -> empty
        // fromNullable -> ofNullable
        // or -> orElse
        // asSet -> ?
        //

    }
}
