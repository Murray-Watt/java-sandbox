package org.mwatt.domain;

import org.mwatt.utilities.NodeImpl;


public class WordFrequency extends NodeImpl<String,Long> {
    public WordFrequency(String word, Long count) {
        super(word,count);
    }

    public String getWord() {return getKey();}
    public Long getCount() {return getValue();}

    public void incFrequency() {incFrequency(1);}
    public void incFrequency(long inc) {setValue(getValue() + inc);}
}
