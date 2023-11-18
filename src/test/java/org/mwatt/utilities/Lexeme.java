package org.mwatt.utilities;

import java.util.List;

public interface Lexeme extends Node<String> {
    String getLexeme();
    List<String> getInflectedForms();
}
