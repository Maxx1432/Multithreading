import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {

        //in above java versions the ExecutorService implements the Auto Closable Interfaces
        // so it can be used with try with resource block

//        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
//            // Submit tasks to the executor
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            service.execute(new Task(i));

        service.shutdown();
    }
}

class Task implements Runnable{

    private final int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("TaskID: "+taskId+" being executed by Thread "+ Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (Exception e){
            System.out.println("Exception");
        }
    }
}
