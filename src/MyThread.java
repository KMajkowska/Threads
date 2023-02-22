import java.util.*;
public class MyThread implements Runnable{

    private Random rand = new Random();

    private double lifetime;
    public MyThread(double lifetime) {
        this.lifetime = lifetime;
    }

    @Override public void run() {
        Date date = new Date();
        long startTime = date.getTime();
        while (date.getTime() < startTime + lifetime) {
            int operation = choose();
            date = new Date();
            synchronized (Main.main) {
                if (operation == 1) {
                    Main.addOneToGlobal();
                } else {
                    Main.minusOneToGlobal();
                }
            }
        }
    }
    public int choose()
    {
       Random rand = new Random();
       return rand.nextInt(2);
    }
}
