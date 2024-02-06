package org.mwatt.utilities;

interface ReadableTree<TKey extends Comparable<TKey>, TValue, TNode extends Node<TKey,TValue>> {
}

interface Tree<TKey extends Comparable<TKey>, TValue, TNode extends Node<TKey,TValue>> extends ReadableTree<TKey, TValue, TNode> {
}



