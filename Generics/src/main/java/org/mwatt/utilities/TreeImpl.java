package org.mwatt.utilities;

public class TreeImpl<TKey, TValue, TNode extends Node<TKey,TValue>> implements Tree<TKey, TValue, TNode> {
    TNode parent;
    TNode node;

    protected TreeImpl(TNode node) {
        this.parent = node;
    }

    public TreeImpl(TNode parent, TNode node) {
        this.node = node;
    }
}
