package org.example.Class13_12;

class StopableThread extends Thread {
    boolean stopThread = false;
    public void pauseThread() {stopThread = true;}
    public void run() {
        while (!stopThread) {
            System.out.println("Executing");
        }
    }
}

class Main_1 {
    public static void main(String[] args) {
        StopableThread thread = new StopableThread();

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.pauseThread();
    }
}