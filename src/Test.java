import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vlad on 25.04.2015.
 */
public class Test {
    public static void main(String[] args) {
        CommonResource1 commonResource1 = new CommonResource1();



        new Thread1(commonResource1);
        //new Thread2(commonResource1);
        //new Thread3(commonResource1);
        new Thread4(commonResource1);
        //new Thread5(commonResource1);
        new BarrieredThread(commonResource1,2);
        new BarrieredThread(commonResource1,3);
        new BarrieredThread(commonResource1,5);


    }



}



