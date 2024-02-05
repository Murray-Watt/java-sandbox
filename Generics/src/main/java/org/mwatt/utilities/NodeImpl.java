package org.mwatt.utilities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
class NodeImpl<TKey,TValue> implements Node<TKey,TValue>{
    private TKey key;
    private TValue value;

    Node<TKey,TValue> createNode(TKey key, TValue value) {
        return new NodeImpl<>(key,value);
    }
}
