package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PruebaInetAdress {
    public static void main(String[] args) {
        InetAddress dir;
        System.out.println("---------- Salida para el Localhost ----------");
        try {
            dir = InetAddress.getLocalHost();
            pruebaMetodos(dir);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMetodo getLocalHost(): " + dir);
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHostAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo getCanonicalHostName(): " + dir.getCanonicalHostName());
    }

}
