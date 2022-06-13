import java.lang.*;

public class FibonacciFriday {

    // Iterative method
    public static int fibLoop(int target) {
        if (target <= 1)
            return target;

        int firstNum = 0;
        int secondNum = 1;
        int sum = 0;

        for (int i = 1; i < target; i++) {
            sum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = sum;

        }

        return sum;
    }

    // Recursive method
    public static int fibRec(int target) {
        if (target <= 1) {
            return target;
        }
        return fibRec(target - 1) + fibRec(target - 2);

    }

    // Timer method that prints out how long each Fibonacci method takes
    public static void displayFib(int target) {
        int loopRun = 0;
        int recRun = 0;

        long startTime = System.nanoTime();
        loopRun = fibLoop(target);
        long loopEndTime = System.nanoTime();
        long loopTime = loopEndTime - startTime;

        startTime = System.nanoTime();
        recRun = fibRec(target);
        long recEndTime = System.nanoTime();
        long recTime = recEndTime - startTime;

        System.out.println("input\t : " + target);
        System.out.println("loop otp : " + fibLoop(target));
        System.out.println("rec otp  : " + fibRec(target));
        System.out.println("time");
        System.out.println("loop\t : " + loopTime);
        System.out.println("recursion: " + recTime + "\n");
    }

    public static void main(String[] args) {

        System.out.println("fibLoop: " + fibLoop(9));
        System.out.println("fibRec: " + fibRec(9));
        displayFib(9);

    }
}
