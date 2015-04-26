import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vlad on 24.04.2015.
 */
public class Thread3 implements Runnable {

    CommonResource1 commonResource1 = new CommonResource1();
    CommonResource2 commonResource2 = new CommonResource2();

    public Thread3(CommonResource1 commonResource1) {
        this.commonResource1 = commonResource1;
        this.commonResource2 = commonResource2;
        new Thread(this, "Thread3").start();

    }

    public void run() {

        System.out.println("Thread3 started");

        while (true) {
            //System.out.print("Thread3 puts: ");
            try {
                System.out.println("Thread3 putStack");
                // commonResource1.putStackCyclicBarrier();
            } catch (Exception e) {
                e.printStackTrace();
           /* } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }*/
            }

        }
    }
}
