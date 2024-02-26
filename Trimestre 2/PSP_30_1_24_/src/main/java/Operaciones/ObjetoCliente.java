package Operaciones;

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
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            Scanner sc = new Scanner(System.in);

            System.out.println("Operacion (suma,resta,multiplicacion,division): ");
            String op = sc.nextLine();
            oos.writeObject(op);

            System.out.println("Num1: ");
            float num1 = sc.nextFloat();
            oos.writeObject(num1);

            System.out.println("Num2: ");
            float num2 = sc.nextFloat();
            oos.writeObject(num2);

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            float res = (float) ois.readObject();
            System.out.println("Resultado: " + res);

            oos.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
