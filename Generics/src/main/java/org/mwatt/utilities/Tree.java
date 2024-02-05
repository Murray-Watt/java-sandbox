package org.mwatt.utilities;

interface ReadableTree<TKey, TValue, TNode extends Node<TKey,TValue>> {
}

interface Tree<TKey, TValue, TNode extends Node<TKey,TValue>> extends ReadableTree<TKey, TValue, TNode> {
}



