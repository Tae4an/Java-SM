public class MultiThread {
    public static void main(String[] args) {
        // Thread 클래스를 상속받아 사용
        Thread thread1 = new ThreadExample();
        thread1.start();

        // Runnable 인터페이스를 구현하여 사용
        Thread thread2 = new Thread(new RunnableExample());
        thread2.start();
    }
}

// Thread 클래스를 상속받아 쓰레드 구현
class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println("Thread 1 is running");
    }
}

// Runnable 인터페이스를 구현하여 쓰레드 구현
class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread 2 is running");
    }
}
