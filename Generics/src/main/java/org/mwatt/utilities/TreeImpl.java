package org.mwatt.utilities;

public class TreeImpl<TKey extends Comparable<TKey>, TValue, TNode extends Node<TKey,TValue>> implements Tree<TKey, TValue, TNode> {
    TNode parent;
    TNode node;

}
