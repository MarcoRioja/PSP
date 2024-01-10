package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PruebaInetAdress_2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        InetAddress dir;
        System.out.println("---------- Salida para el Localhost ----------");
        System.out.print("Write direction: ");
        String direction = sc.nextLine();
        try {
            dir = InetAddress.getByName(direction);
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
