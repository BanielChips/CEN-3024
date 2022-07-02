import java.util.Random;

public class SingleThreadSumArrayCompare extends Thread{
    private static int[] bigArray = new int[200000000];
    private static int sum = 0;

    private static long startTime = 0;
    private static long endTime = 0;
    private static long duration = 0;

    public static synchronized void methodPacker(int index){
        startTime = System.nanoTime();
        randomInt(index);
        sumArray(index);
        endTime = System.nanoTime();
        duration = endTime - startTime;
    }
    public static synchronized void randomInt(int index){
        bigArray[index] = (int)(Math.random() * 10 + 1);
    }
    public static synchronized void sumArray(int index){
        sum += bigArray[index];
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < bigArray.length; i++){
                    methodPacker(i);
                }
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("Sum: " + sum);
        System.out.println("bigArray.length: " + bigArray.length);
        System.out.println("duration sinT: " + duration);
        System.out.println("startTime: " + startTime);
        System.out.println("endTime: " + endTime);
    }
}
