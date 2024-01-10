package org.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class PruebaInetAdress_1 {
    public static void main(String[] args) {
        InetAddress dir;
        System.out.println("---------- Salida para el Localhost ----------");
        try {
            dir = InetAddress.getByName("www.cenecmalaga.es");
            // Tambien en vez de la direccion se puede usar la ip o el nombre del equipo
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
