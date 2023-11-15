package org.example;

import java.io.IOException;
import java.io.InputStream;

public class ShowTasks {

    static Process p;

    public static void printProcess(Process nP) throws IOException {
        InputStream is = nP.getInputStream();
        int c;
        while ((c = is.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void printErrorProcess(Process nP) throws IOException {
        InputStream is = nP.getErrorStream();
        int c;
        while ((c = is.read())!= -1) {
            System.out.print((char) c);
        }
    }

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","tasklist");
        try {
            p = pb.start();
            printProcess(p);
            printErrorProcess(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
