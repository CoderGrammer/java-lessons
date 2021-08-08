package com.lessons.optional;

import com.lessons.optional._08_PreventingNullBeforeOptional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NotNullTest {

    @Test
    void dontBeNull() {
        var v = new _08_PreventingNullBeforeOptional();
        assertNotNull(v.getSomeValue());

    }

}
