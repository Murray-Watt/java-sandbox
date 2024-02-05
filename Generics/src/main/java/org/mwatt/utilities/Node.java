package org.mwatt.utilities;

interface ReadableNode<TKey,TValue>{
    TKey getKey();
    TValue getValue();
}

interface Node<TKey,TValue> extends ReadableNode<TKey,TValue>{
}
