package com.lessons;

import com.lessons.optional._03_PreventingNullBeforeOptional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NotNullTest {

    @Test
    void dontBeNull() {
        _03_PreventingNullBeforeOptional z_preventingNullBeforeOptional = new _03_PreventingNullBeforeOptional();
        Assertions.assertNotNull(z_preventingNullBeforeOptional.getSomeValue());

    }

}
