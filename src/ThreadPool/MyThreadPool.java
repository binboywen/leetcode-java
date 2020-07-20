package ThreadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

class CodingTask implements Runnable{
    private int aaa;
    CodingTask(int i){
        aaa = i;
    }

    @Override
    public void run() {
        System.out.println(aaa);
    }
}
public class MyThreadPool {
    public static void main1(String [] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i ++){
            executor.submit(new CodingTask(i));
        }
        System.out.println("10 task dispatched successfully");
        executor.shutdown();
    }
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        List<Future<?>> taskResult = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            taskResult.add(executor.submit(new CodingTask(i)));
        }
        System.out.println("10 task dispatched successfully");
        for(Future<?> task : taskResult){
            task.get();
        }
        executor.shutdown();
    }
}
