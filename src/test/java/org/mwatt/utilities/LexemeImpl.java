package org.mwatt.utilities;

import java.util.List;

class LexemeImpl extends NodeImpl<String> implements Lexeme {

    public String getLexeme() {
        return getKey();
    }

    @Override
    public List<String> getInflectedForms() {
        return null;
    }

    LexemeImpl(String lexeme) {
        super(lexeme);
    }
}
