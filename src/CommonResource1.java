import sun.awt.Mutex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Created by Vlad on 24.04.2015.
 */
public class CommonResource1 {

    private static Deque<Integer> stack = new ArrayDeque<Integer>();
    private Random random = new Random();
    final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("Barrier tripped");
        }
    });
    static Semaphore semaphoreProducer = new Semaphore(1);
    static Semaphore semaphoreConsumer = new Semaphore(0);
    static Semaphore semaphoreThread1_4 = new Semaphore(1);
    static Semaphore semaphoreThread2_3_5 = new Semaphore(0);
    static Mutex mutex = new Mutex();



    public synchronized void getStack() throws InterruptedException {
    //mutex.lock();
        synchronized(System.out){
            System.out.println("Thread4 gets: " + stack.peekFirst());
        }
        stack.pop();
    //mutex.unlock();
    }

    public synchronized void putStackSemaphore() throws InterruptedException {
            //mutex.lock();
            //semaphoreThread1_4.acquire();
            stack.addFirst(random.nextInt());
            synchronizeSystemOutString(1);
            //semaphoreThread2_3_5.release();
            //mutex.unlock();

    }

    public synchronized void putStackCyclicBarrier(int i) throws InterruptedException, BrokenBarrierException {
        //mutex.lock();
        //semaphoreThread2_3_5.acquire();
        stack.addFirst(random.nextInt());
        synchronizeSystemOutString(i);
        //semaphoreThread1_4.release();
        //mutex.unlock();
    }

    public void synchronizeSystemOutString(int i) {
        synchronized (System.out) {
            System.out.println("Thread" + i + " puts: " + stack.peekFirst());
        }
    }
}


