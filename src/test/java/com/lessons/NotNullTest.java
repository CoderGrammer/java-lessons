package com.lessons;

import com.lessons.optional._3_PreventingNullBeforeOptional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotNullTest {

    @Test
    void dontBeNull() {
        _3_PreventingNullBeforeOptional z_preventingNullBeforeOptional = new _3_PreventingNullBeforeOptional();
        Assertions.assertNotNull(z_preventingNullBeforeOptional.getSomeValue());

    }

}
