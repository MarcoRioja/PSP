package org.example;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PruebaInetAdress_3 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        InetAddress dir;
        System.out.println("Constructor simple para una URL");
        URL url;
        try {
            url = new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ&ab_channel=RickAstley");
            Visualizar(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Visualizar(URL url) {
        System.out.println("\tURL completa: " + url);
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost(): " + url.getHost());
        System.out.println("\tgetDefaultPort: " + url.getDefaultPort());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetPath(): " + url.getPath());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out.println("\tgetFile(): " + url.getFile());
        System.out.println("\tgetAuthority(): " + url.getAuthority());
    }

}
