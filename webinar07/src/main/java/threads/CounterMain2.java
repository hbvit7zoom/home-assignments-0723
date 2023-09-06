package threads;

import java.util.ArrayList;
import java.util.List;

public class CounterMain2 {

    public static void main(String[] args) {
        final Integer counter = 0;

        List<Thread> threads = new ArrayList<>();

        for (int i=0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

//                counter = counter + 1;

            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(counter);

    }

}
