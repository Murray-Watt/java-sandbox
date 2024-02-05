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

    @Test
    void namespacesWithSameFullNameAreEqual() {
        Namespace namespace1 = new Namespace("parent");
        Namespace namespace2 = new Namespace("parent");

        assertEquals(namespace1, namespace2, "Namespaces with empty parent and the same leaf are equal should be equal");

        Namespace namespace3 = new Namespace(namespace1,"child");
        Namespace namespace4 = new Namespace(namespace1, "child");

        assertEquals(namespace3, namespace4, "Namespaces with the same full name should be equal");
    }

    @Test
    void differentNamespacesAreNotEqual() {
        Namespace namespace1 = new Namespace("parent1");
        Namespace namespace2 = new Namespace("parent2");

        assertNotEquals(namespace1, namespace2, "Namespaces with different leaf names should not be equal");

        Namespace namespace3 = new Namespace(namespace1,"child1");
        Namespace namespace4 = new Namespace(namespace1, "child2");

        assertNotEquals(namespace3, namespace4, "Namespaces with different leaf names should not be equal");

        Namespace namespace5 = new Namespace("parent2");
        Namespace namespace6 = new Namespace(namespace5,"child3");

        assertNotEquals(namespace1, namespace6, "Namespaces with different parents and leaf node should not be equal");
    }

    @Test
    void namespacesWithDifferentFullNameHaveTheSameHashCode() {
        Namespace namespace1 = new Namespace("parent1");
        Namespace namespace2 = new Namespace("parent2");

        assertNotEquals(namespace1.hashCode(), namespace2.hashCode(), "Namespaces with no parent and the same leaf node full names should have the same hash codes");

        Namespace namespace3 = new Namespace(namespace1,"child");
        Namespace namespace4 = new Namespace(namespace1, "child");

        assertEquals(namespace3.hashCode(), namespace4.hashCode(), "Namespaces with the same full name should have the same hash codes");
    }

    @Test
    void namespacesWithDifferentFullNameHaveDifferentHashCode() {
        Namespace namespace1 = new Namespace("parent1");
        Namespace namespace2 = new Namespace("parent2");

        assertNotEquals(namespace1, namespace2, "Namespaces with different leaf names should have different hash codes");

        Namespace namespace3 = new Namespace(namespace1,"child1");
        Namespace namespace4 = new Namespace(namespace1, "child2");

        assertNotEquals(namespace3, namespace4, "Namespaces with different leaf names should have different hash codes");

        Namespace namespace5 = new Namespace("parent2");
        Namespace namespace6 = new Namespace(namespace5,"child3");

        assertNotEquals(namespace1, namespace6, "Namespaces with different parents and leaf node should have different hash codes");
    }
}