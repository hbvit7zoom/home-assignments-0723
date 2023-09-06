package threads;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
//            try {
//                myThread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        });

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        };

        Runnable runnable = () -> System.out.println(Thread.currentThread().getName());

        new Thread(runnable).start();

        thread.start();
//        thread.run();

        myThread.join();
        thread.join();

        System.out.println(Thread.currentThread().getName());
    }
}
