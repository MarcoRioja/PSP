package org.example;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    static Process p;
    public static void main(String[] args) {
        try {
            createProcess("CMD","/C","start chrome");
            printProcess(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createProcess(String app) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(app);
        p = pb.start();
    }

    public static void createProcess(String app, String disk, String command) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(app,disk,command);
        p = pb.start();
    }

    public static void printProcess(Process p) throws IOException {
        InputStream is = p.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void printErrorProcess(Process p) throws IOException {
        InputStream is = p.getErrorStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
    }
}