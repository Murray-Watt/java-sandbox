package org.mwatt.utilities;

public class TreeImpl<TKey,TNode extends Node<TKey>> implements Tree<TKey,TNode> {
    TNode parent;
    TNode node;

    protected TreeImpl(TNode node) {
        this.parent = node;
    }

    public TreeImpl(TNode parent, TNode node) {
        this.node = node;
    }
}
