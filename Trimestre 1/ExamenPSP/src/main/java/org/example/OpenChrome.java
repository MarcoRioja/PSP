package org.example;

import java.io.IOException;

public class OpenChrome {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","start chrome");
        try {
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
