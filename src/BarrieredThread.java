import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vlad on 24.04.2015.
 */
public class BarrieredThread implements Runnable {

    CommonResource1 commonResource1;
    CommonResource2 commonResource2;
    int number;

    public BarrieredThread(CommonResource1 comRes1,CommonResource2 comRes2, int i) {
        number = i;
        commonResource1 = comRes1;
        commonResource2 = comRes2;
        new Thread(this, "Thread" + number).start();

    }

    public void run() {

        System.out.println("Thread" + number +  " started");

        while (true) {
            try {
                commonResource1.putStackCyclicBarrier(number);
                commonResource2.Mutex1_2_3.lock();
                commonResource2.setSemaphore(number);
                commonResource2.Mutex1_2_3.unlock();
                commonResource1.cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            }

        }

    }

