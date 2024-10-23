package org.example;

import com.google.common.base.Joiner;

public class SomeImportantClass {

    public String getGreeting() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        return joiner.join("Harry", null, "Ron", "Hermione");
    }

}
