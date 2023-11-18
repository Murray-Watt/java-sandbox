package org.mwatt.utilities;

public class LexemeTreeImpl extends TreeImpl<String, LexemeImpl> implements LexemeTree {
   LexemeTreeImpl(LexemeImpl node) {
        super(node);
    }

    LexemeTreeImpl(LexemeImpl parent, LexemeImpl node) {
        super(parent, node);
    }
}
