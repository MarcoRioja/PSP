package Monedas;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ObjetoCliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        try {
            Socket cliente = new Socket(host, puerto);
            System.out.println("Conectado con Servidor en el puerto: " + cliente.getPort());

            Scanner sc = new Scanner(System.in);
            System.out.println("Dinero en €: ");
            float money = sc.nextFloat();

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            oos.writeObject(money);

            oos.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
