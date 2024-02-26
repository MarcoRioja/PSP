package Suma;

import java.io.IOException;
import java.io.ObjectInputStream;
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
            System.out.println("Num1: ");
            float num1 = sc.nextFloat();

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(num1);
            System.out.println("Num2: ");
            float num2 = sc.nextFloat();
            oos.writeObject(num2);

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            float suma = (float) ois.readObject();
            System.out.println("Suma: " + suma);

            oos.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
