package Pokemon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ObjetoServidor {
    public static void main(String[] args) {
        int puerto = 6000;
        ServerSocket servidor;
        try {
            servidor = new ServerSocket(puerto);
            System.out.println("Esperando al cliente en el puerto: " + servidor.getLocalPort());
            Socket cliente = servidor.accept(); // Espera una petición de un cliente, el main se detiene.

            ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
            Pokemon pokemon = (Pokemon) ois.readObject();
            ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject("El entrenador Gary quiere luchar Y/N: ");
            if (((String) ois.readObject()).equals("Y")) {
                int random = new Random().nextInt(0,100);
                if (random < 50) {
                    oos.writeObject("Has perdido");
                    pokemon.setVida(0);
                    oos.writeObject(pokemon);
                } else {
                    oos.writeObject("Has ganado");
                    pokemon.setNivel(pokemon.getNivel()+1);
                    oos.writeObject(pokemon);
                }
            }

            cliente.close();
            servidor.close();
        } catch(IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
