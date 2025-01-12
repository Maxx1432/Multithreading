import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(new ProbeTask(),
                1000, 2000, TimeUnit.MILLISECONDS);
//        It takes
        //(Runnable, initial delay, delay, Unit of Time Delay)

        try{
            if(!scheduledExecutorService.awaitTermination(10000, TimeUnit.MILLISECONDS)){
                scheduledExecutorService.shutdown();
            }
        }catch (Exception e){
         scheduledExecutorService.shutdown();
        }
    }
}

class ProbeTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Probing end point for updates.....");
    }
}
