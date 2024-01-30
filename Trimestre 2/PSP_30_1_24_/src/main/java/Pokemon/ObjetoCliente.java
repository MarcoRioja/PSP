package Pokemon;

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

            Pokemon pikachu = new Pokemon("Pikachu",100,5);

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            oos.writeObject(pikachu);

            System.out.println("Enviado " + pikachu.getNombre() + " a nivel " + pikachu.getNivel() + ".");

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            System.out.println((String)ois.readObject());
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("Y")) {
                System.out.println("Has aceptado el combate");
                oos.writeObject("Y");
            } else {
                System.out.println("Has rechazado el combate");
                oos.writeObject("N");
            }
            System.out.println((String)ois.readObject());
            pikachu = (Pokemon) ois.readObject();
            System.out.println(pikachu.getNombre() + " " + pikachu.getVida() + "HP - " + pikachu.getNivel() + "Lvl");


            oos.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
