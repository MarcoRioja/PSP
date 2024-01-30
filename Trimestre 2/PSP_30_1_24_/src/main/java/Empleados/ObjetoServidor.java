package Empleados;

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

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            Empleados empleado1 = new Empleados("Alberto", 3000);

            oos.writeObject(empleado1);
            System.out.println("Envío: " + empleado1.getNombre() + " con sueldo mensual de " + empleado1.getSueldo());

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            Empleados empleado = (Empleados) ois.readObject();
            System.out.println("Se ha recibido al empleado " + empleado.getNombre() + " con la modificación de sueldo" + empleado.getSueldo() + "€.");
            oos.close();
            cliente.close();
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}