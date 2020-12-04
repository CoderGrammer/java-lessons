package com.lessons;

import com.lessons.optional._2_Z_PreventingNullBeforeOptional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotNullTest {

    @Test
    void dontBeNull() {
        _2_Z_PreventingNullBeforeOptional z_preventingNullBeforeOptional = new _2_Z_PreventingNullBeforeOptional();
        Assertions.assertNotNull(z_preventingNullBeforeOptional.getSomeValue());

    }

}
