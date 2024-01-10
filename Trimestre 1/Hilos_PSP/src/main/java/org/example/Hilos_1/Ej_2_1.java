package org.example.Hilos_1;

public class Ej_2_1 extends Thread {

    @Override
    public void run() {
        if (getName().equals("Thread-0")) { while (true) {System.out.println(getName() + " - Tick");}}
        else { while (true) {System.out.println(getName() + " - Tack");}}

    }

    public static void main(String[] args) {
        Ej_2_1 h0 = new Ej_2_1();
        Ej_2_1 h1 = new Ej_2_1();

        h0.start();
        h1.start();
    }
}
