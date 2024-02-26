package Monedas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjetoServidor {
    public static void main(String[] args) {
        int puerto = 6000;
        ServerSocket servidor;
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Esperando al cliente en el puerto: " + servidor.getLocalPort());
            Socket cliente = servidor.accept(); // Espera una petición de un cliente, el main se detiene.

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            float money = (float) ois.readObject();
            System.out.println("Se ha recibido " + money + "€.");
            System.out.println("Dolares: " + money * 1.08f + ".");
            System.out.println("Yenes: " + money * 159.74f + ".");
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}