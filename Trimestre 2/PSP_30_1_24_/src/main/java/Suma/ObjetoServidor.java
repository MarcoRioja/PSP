package Suma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

            float num1 = (float) ois.readObject();
            float num2 = (float) ois.readObject();

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(num1+num2);

            cliente.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}