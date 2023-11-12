package org.mwatt.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamespaceTest {

    @Test
    void canCreateChildNamespace() {
        Namespace parent = new Namespace("parent");
        Namespace child = new Namespace(parent, "child");

        assertEquals("/parent", parent.getFullName());
        assertEquals("/parent/child", child.getFullName());
    }
}