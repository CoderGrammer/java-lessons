package com.lessons.optional;

import com.lessons.collections.selector.CollectionsSelector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsSelectorTest {

    private CollectionsSelector collectionsSelector;

    @Disabled
    @Test
    void getABasicCollectionHappy() {
        assertEquals("ArrayList (Java)", collectionsSelector.getCollection());
    }

}
