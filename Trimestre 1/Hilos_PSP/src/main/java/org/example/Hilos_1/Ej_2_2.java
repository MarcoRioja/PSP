package org.example.Hilos_1;

public class Ej_2_2 extends Thread {


    @Override
    public void run() {
        boolean tick = false;
        while (true) {
            if (!tick) {System.out.println(Thread.currentThread().getName() + " - Tick"); tick = true;}
            else {System.out.println(Thread.currentThread().getName() + " - Tack"); tick = false;}
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Ej_2_2 h0 = new Ej_2_2();

        h0.start();
    }
}
