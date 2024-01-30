package Empleados;

import java.io.*;
import java.net.Socket;

public class ObjetoCliente {

    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        try {
            Socket cliente = new Socket(host, puerto);
            System.out.println("Conectado con Servidor en el puerto: " + cliente.getPort());

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

            Empleados empleado = (Empleados) ois.readObject();
            System.out.println("Se ha recibido al empleado " + empleado.getNombre());

            empleado.setSueldo(4000);

            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());

            oos.writeObject(empleado);

            System.out.println("Se ha modificado el suedo del empleado " + empleado.getNombre() + " a " + empleado.getSueldo() + "€.");

            ois.close();
            oos.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
