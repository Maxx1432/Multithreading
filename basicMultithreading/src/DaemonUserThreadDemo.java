public class DaemonUserThreadDemo {
    public static void main(String[] args) {
        // By default threads are user thread, to make thread daemon thread is calling .setDaemon() method
        Thread bgThread = new Thread(new DaemonHlper());
        Thread userThread = new Thread(new UserThreadHelper());

        bgThread.setDaemon(true);

        bgThread.start();
        userThread.start();

    }
}

class DaemonHlper implements Runnable{

    @Override
    public void run() {
        int count = 0;
        while(count < 500){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Deamon Helper running.....");
        }
    }
}

class UserThreadHelper implements Runnable{
    @Override
    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("user thread done execution....");
    }
}