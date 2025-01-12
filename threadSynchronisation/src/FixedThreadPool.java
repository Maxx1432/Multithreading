import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 5; i++)
            executorService.execute(new Work(i));

        executorService.shutdown();

    }
}

class Work implements Runnable{

   private final int workId;

    public Work(int workId){
        this.workId = workId;
    }
    @Override
    public void run() {
        System.out.println("WorkID: "+workId+" being executed by Thread "+ Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
