package org.mwatt.utilities;

interface ReadableTree<TKey, TNode extends Node<TKey>> {
}

interface Tree<TKey, TNode extends Node<TKey>> extends ReadableTree<TKey, TNode> {
}



