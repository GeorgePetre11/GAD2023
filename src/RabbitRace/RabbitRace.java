package RabbitRace;

import java.util.ArrayList;
import java.util.List;

public class RabbitRace {
    private List<Thread> threads;

    public RabbitRace() {
        threads = new ArrayList<>();
    }

    public void addRabbitThread(int nr) {
        RabbitThread rabbit = new RabbitThread(nr);
        threads.add(rabbit);
    }

    public void addRabbitRunnable(int nr) {
        RabbitRunnable rabbit = new RabbitRunnable(nr);
        Thread thread = new Thread(rabbit);
        threads.add(thread);
    }

    public void startRace() {
        for (int i = 0; i < threads.size(); i++) {
            Thread rabbit = threads.get(i);
            if (i % 2 == 0 && rabbit instanceof RabbitThread) {
                rabbit.start();
            } else if (i % 2 == 1 && rabbit instanceof Thread) {
                rabbit.start();
            }
        }
    }

    public static void main(String[] args) {
        RabbitRace race = new RabbitRace();

        for (int i = 1; i <= 5; i++) {
            race.addRabbitThread(i);
            race.addRabbitRunnable(i);
        }

        // start the race
        race.startRace();
    }
}

class RabbitThread extends Thread {
    private int nr;

    public RabbitThread(int nr) {
        this.nr = nr;
    }

    public void run() {
        System.out.println("Rabbit #" + nr + " is running");
    }
}

class RabbitRunnable implements Runnable {
    private int nr;

    public RabbitRunnable(int nr) {
        this.nr = nr;
    }

    public void run() {
        System.out.println("Rabbit #" + nr + " is running");
    }
}
