public class ThreadPriorityExample {
    public static void main(String[] args) {
        //To get the name of current thread
        System.out.println(Thread.currentThread().getName());

        //To get the priority of current thread
        System.out.println(Thread.currentThread().getPriority());

        //To change the priority
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        System.out.println(Thread.currentThread().getPriority());
    }
}
