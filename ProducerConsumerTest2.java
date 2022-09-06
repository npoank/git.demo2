package patern.producerconsumer;

import java.util.Scanner;

public class ProducerConsumerTest2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello JAVA !!!");
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
class WaitAndNotify{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("working ...");
            wait();
            System.out.println("continue ...");
        }
    }

    public void consume() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        synchronized (this){
            Thread.sleep(2000);
            System.out.println("press enter to continue ");
            scanner.nextLine();
            notify();
        }
    }

}

