package Operaciones;

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

            String op = (String) ois.readObject();
            float num1 = (float) ois.readObject();
            float num2 = (float) ois.readObject();

            float res;
            switch (op) {
                case "suma":
                    res = num1 + num2;
                    break;
                case "resta":
                    res = num1 - num2;
                    break;
                case "multiplicacion":
                    res = num1 * num2;
                    break;
                case "division":
                    res = num1 / num2;
                    break;
                default:
                    res = 0.0f;
                    break;
            }

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(res);

            cliente.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}