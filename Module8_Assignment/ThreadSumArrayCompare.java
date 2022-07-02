import java.util.Random;

public class ThreadSumArrayCompare extends Thread {
    private static int[] bigArray = new int[200000000]; 
    private static int bigHalf = bigArray.length/2;
    private static int sum = 0;
    
    private static long startTime = 0;
    private static long endTime = 0;
    private static long duration = 0;

    // Sync method to initialize the array indexes with rand ints
    public static synchronized void methodPacker(int index){
        startTime = System.nanoTime();
        randomInt(index);
        sumInt(index);
        endTime = System.nanoTime();
        duration = endTime - startTime;
    }
    public static synchronized void randomInt(int index){
        bigArray[index] = (int)(Math.random() * 10 + 1);
    }
    public static synchronized void sumInt(int indexValue){
        sum += bigArray[indexValue];
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < bigHalf; i++){
                    methodPacker(i);
               }
               
           } 
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = bigHalf; i < bigArray.length; i++){
                    methodPacker(i);
                } 
            } 
         });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Sum: " + sum);
        System.out.println("bigArray.length: " + bigArray.length);
        System.out.println("duration par: " + duration);
        System.out.println("startTime: " + startTime);
        System.out.println("endTime: " + endTime);
    }
}

