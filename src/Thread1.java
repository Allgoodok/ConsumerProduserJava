import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

/**
 * Created by Vlad on 24.04.2015.
 */
public class Thread1 implements Runnable {
    Random random = new Random();

    CommonResource1 commonResource1 = new CommonResource1();
    CommonResource2 commonResource2 = new CommonResource2();

    public Thread1(CommonResource1 commonResource1) {
        this.commonResource1 = commonResource1;
        this.commonResource2 = commonResource2;
        new Thread(this, "Producer1").start();

    }

    public void run() {

        System.out.println("Thread1 started");

        while(true){
            //System.out.print("Thread1 puts: ");
            try {
               // System.out.println("Thread1 putStack ");
                commonResource1.semaphoreProducer.acquire();
                commonResource1.putStackSemaphore();
                commonResource1.semaphoreConsumer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
