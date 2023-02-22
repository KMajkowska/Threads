import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static  int global = 0;
    public static long time;
    public static Main main = new Main();

    public static void main(String [] args)
    {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.println("How many threads do you want to create?");
        n = scan.nextInt();
        System.out.println("How long should thread be alive?");
        time = scan.nextLong();
        ExecutorService exec = Executors.newFixedThreadPool(n);
        for(int i = 0; i<n; i++)
        {
            exec.execute(new MyThread(time));
        }
        exec.shutdownNow();
        System.out.println("Finally version of global variable: " + global);
    }

    public static void addOneToGlobal()
    {
        global = global+1;
    }

    public static void minusOneToGlobal()
    {
        global = global-1;
    }

}
