package org.example.Hilos_1;

public class Dos_Hilos extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ": " + i);
        }
    }

    public Dos_Hilos() {

    }

    public Dos_Hilos(String name) {
        setName(name);
    }

    public static void main(String[] args) {
        Dos_Hilos hilo1 = new Dos_Hilos();
        Dos_Hilos hilo2 = new Dos_Hilos();
        hilo1.start();
        hilo2.start();

        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        hilo1.setName("Hilo 1");
        hilo2.setName("Hilo 2");
        System.out.println("jijiji, hola, cuando me ejecuto?");
    }


}
