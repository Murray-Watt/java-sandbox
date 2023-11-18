package org.mwatt.utilities;

import lombok.Getter;

class NodeImpl<TKey> implements Node<TKey>{
    @Getter
    private TKey key;

    NodeImpl(TKey key) {
        this.key = key;
    }

    Node<TKey> createNode(TKey key) {
        return new NodeImpl<>(key);
    }
}
