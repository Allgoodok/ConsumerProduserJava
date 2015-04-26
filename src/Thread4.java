/**
 * Created by Vlad on 25.04.2015.
 */
public class Thread4 implements Runnable {
    CommonResource1 commonResource1 = new CommonResource1();
    CommonResource2 commonResource2 = new CommonResource2();

    public Thread4(CommonResource1 commonResource1) {
        this.commonResource1 = commonResource1;
        this.commonResource2 = commonResource2;
        System.out.println("Thread4 started");
        new Thread(this, "Consumer").start();
    }

    public  void run(){


        while(true){
            //System.out.print("Thread4 gets: ");
            try {
                //System.out.println("Thread4 getStack ");
                commonResource1.semaphoreConsumer.acquire();
                commonResource1.getStack();
                commonResource1.semaphoreProducer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }

}
