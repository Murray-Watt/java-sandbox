package org.mwatt.utilities;

import lombok.Getter;
import lombok.Setter;

@Getter
public class NodeImpl<TKey extends Comparable<TKey>,TValue> implements Node<TKey,TValue>{
    final protected TKey key;

    @Setter
    protected TValue value;

    public NodeImpl(TKey key, TValue value) {
        this.key = key;
        this.setValue(value);
    }

    @Override
    public int compareTo(Node<TKey, TValue> otherNode) {
        return this.key.compareTo(otherNode.getKey());
    }
}
