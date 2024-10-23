package com.google.common.base;

import org.apache.commons.lang3.StringUtils;

public class Joiner {

    private String joinStr;
    boolean skipNull;

    public static Joiner on(String joinStr) {
        Joiner joiner = new Joiner();
        joiner.joinStr = joinStr;
        return joiner;
    }

    public Joiner skipNulls() {
        this.skipNull = true;
        return this;
    }

    public String join(String... s) {
        String result = StringUtils.join(s, joinStr);
        return "I will pretend it is joined: " + result;
    }
}
