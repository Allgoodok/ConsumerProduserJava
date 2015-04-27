import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Vlad on 25.04.2015.
 */
public class Test {
    public static void main(String[] args) {
        CommonResource1 commonResource1 = new CommonResource1();
        CommonResource2 commonResource2 = new CommonResource2();



        new Thread1(commonResource1, commonResource2);
        new Thread4(commonResource1);
        new BarrieredThread(commonResource1, commonResource2,2);
        new BarrieredThread(commonResource1, commonResource2,3);
        new BarrieredThread(commonResource1, commonResource2,5);


    }



}



