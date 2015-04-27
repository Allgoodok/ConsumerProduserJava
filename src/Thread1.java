import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

/**
 * Created by Vlad on 24.04.2015.
 */
public class Thread1 implements Runnable {

    CommonResource1 commonResource1 = new CommonResource1();
    CommonResource2 commonResource2 = new CommonResource2();

    public Thread1(CommonResource1 commonResource1,CommonResource2 comRes2) {
        this.commonResource1 = commonResource1;
        this.commonResource2 = comRes2;
        new Thread(this, "Producer1").start();

    }

    public void run() {

        System.out.println("Thread1 started");

        while(true){
            try {
                commonResource1.semaphoreProducer.acquire();
                commonResource1.putStackSemaphore();
                commonResource2.Mutex1_2_3.lock();
                commonResource2.setSemaphore(1);
                commonResource2.Mutex1_2_3.unlock();
                commonResource1.semaphoreConsumer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
