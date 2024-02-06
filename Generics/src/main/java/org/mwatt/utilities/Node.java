package org.mwatt.utilities;

interface ReadableNode<TKey extends Comparable<TKey>, TValue> extends Comparable<Node<TKey, TValue>> {
    TKey getKey();
    TValue getValue();
}

public interface Node<TKey extends Comparable<TKey>, TValue> extends ReadableNode<TKey, TValue> {
    void setValue(TValue value);
}