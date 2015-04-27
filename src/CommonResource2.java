import sun.awt.Mutex;

import java.util.Random;

/**
 * Created by Vlad on 24.04.2015.
 */
public class CommonResource2 {

    private static Random random = new Random();

    private static byte javaByte;
    private static short javaShort;
    private static int javaInt;
    private static long javaLong;
    private static char javaChar;
    static Mutex Mutex1_2_3 = new Mutex();

    public CommonResource2() {
        this.setJavaByte();
        this.setJavaShort();
        this.setJavaInt();
        this.setJavaLong();
        this.setJavaChar();
    }

    public static byte getJavaByte() {
        return javaByte;
    }

    public static void setJavaByte() {
        CommonResource2.javaByte =  (byte)random.nextInt(127);
    }

    public static short getJavaShort() {
        return javaShort;
    }

    public static void setJavaShort() {
        CommonResource2.javaShort = (short)random.nextInt(32767);
    }

    public static int getJavaInt() {
        return javaInt;
    }

    public static void setJavaInt() {
        CommonResource2.javaInt = random.nextInt();
    }

    public static long getJavaLong() {
        return javaLong;
    }

    public static void setJavaLong() {
        CommonResource2.javaLong = random.nextLong();
    }

    public static char getJavaChar() {
        return javaChar;
    }

    public static void setJavaChar() {
        CommonResource2.javaChar = (char)random.nextInt(255);
    }

    public void setSemaphore(int i) {




        switch (i){
            case 1: synchronizeSystemOutString(i);
                    setJavaByte();
                    synchronizeSystemNumber(javaByte);
                    setJavaChar();
                    synchronizeSystemNumber(javaChar);
                    setJavaInt();
                    synchronizeSystemNumber(javaInt);
                    setJavaLong();
                    synchronizeSystemNumber(javaLong);
                    break;

            case 2:
                    synchronizeSystemOutString(i);
                    setJavaShort();
                    synchronizeSystemNumber(javaShort);
                    setJavaLong();
                    synchronizeSystemNumber(javaLong);
                    setJavaInt();
                    synchronizeSystemNumber(javaInt);
                    setJavaChar();
                    synchronizeSystemNumber(javaChar);
                    break;

            case 3:
                    synchronizeSystemOutString(i);
                    setJavaByte();
                    synchronizeSystemNumber(javaByte);
                    setJavaShort();
                    synchronizeSystemNumber(javaShort);
                    setJavaLong();
                    synchronizeSystemNumber(javaLong);
                    setJavaChar();
                    synchronizeSystemNumber(javaChar);
                    break;
        }
    }

    public void synchronizeSystemOutString(int i) {
        synchronized (System.out){
            System.out.println("Thread" + i + " changes: ");
        }
    }

    public void synchronizeSystemNumber(byte javaType) {
        synchronized (System.out){
            System.out.println("javaByte changed to: " + getJavaByte());
        }
    }


    public void synchronizeSystemNumber(short javaType){
        synchronized (System.out){
            System.out.println("javaShort changed to: " + getJavaShort());
        }
    }

    public void synchronizeSystemNumber(int javaType){
        synchronized (System.out){
            System.out.println("javaInt changed to: " + getJavaInt());
        }
    }

    public void synchronizeSystemNumber(long javaType){
        synchronized (System.out){
            System.out.println("javaLong changed to: " + getJavaLong());
        }
    }

    public void synchronizeSystemNumber(char javaType){
        synchronized (System.out){
            System.out.println("javaChar changed to: " + getJavaChar());
        }
    }

}
