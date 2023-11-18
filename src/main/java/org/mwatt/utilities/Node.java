package org.mwatt.utilities;

interface ReadableNode<TKey>{
    TKey getKey();
}

interface Node<TKey> extends ReadableNode<TKey>{
}
