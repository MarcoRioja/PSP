package org.example.Hilos_1;

public class Ej_1 extends Thread{

    boolean par;
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            if (par) { if (i % 2 == 0) { System.out.println(getName() + " - " + i + " - Par");}}
            else { if (i % 2 != 0) { System.out.println(getName() + " - " + i + " - Impar");}}
        }
    }

    public Ej_1(boolean par){
        this.par = par;
    }

    public static void main(String[] args) {
        Ej_1 h0 = new Ej_1(true);
        Ej_1 h1 = new Ej_1(false);
        h0.start();
        h1.start();
    }
}
