import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0; i < 1000; i++)
                executorService.execute(new TaskOne(i));

        executorService.shutdown();
    }
}

class TaskOne implements Runnable{

    private final int taskId;

    public TaskOne(int taskId){
        this.taskId = taskId;
    }
    @Override
    public void run() {
        System.out.println("TaskID: "+taskId+" being executed by Thread "+ Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
