package org.example.Class13_12;

class Arriba extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " cuenta " + i);
        }
        System.out.println("Fin de " + getName());
    }
}

class Abajo extends Thread {
       public void run() {
           for (int i = 100; i > 0; i--) {
                System.out.println(getName() + " cuenta " + i);
           }
           System.out.println("Fin de " + getName());
       }
}

class Main {
    public static void main(String[] args) {
        Arriba h1 = new Arriba();
        h1.setName("Hilo Arriba");
        Abajo h2 = new Abajo();
        h2.setName("Hilo Abajo");

        h1.start();
        h2.start();

        try {
            h1.join();
            h2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
