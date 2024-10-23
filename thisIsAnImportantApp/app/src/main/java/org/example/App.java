package org.example;

import com.google.common.base.Joiner;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class App {
    public String getGreeting() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        return joiner.join("Harry", null, "Ron", "Hermione");
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println(app.getGreeting());
    }
}
