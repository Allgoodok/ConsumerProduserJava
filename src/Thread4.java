/**
 * Created by Vlad on 25.04.2015.
 */
public class Thread4 implements Runnable {
    CommonResource1 commonResource1 = new CommonResource1();

    public Thread4(CommonResource1 commonResource1) {
        this.commonResource1 = commonResource1;
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
