package execution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 *  FutureTask执行Callable任务
 */
public class MyFutureTask2 {
	public static void main(String[] args){   
		ExecutorService executorService = Executors.newCachedThreadPool(); 
        
        List<Future<String>> tasks = new ArrayList<Future<String>>();  
        
        //创建10个任务并执行   
        for (int i = 0; i < 10; i++){   
           if(!executorService.isShutdown()) {
        	   
        	   FutureTask<String> task = new FutureTask<String>(new Result());  
        	   tasks.add(task);
        	   
        	   executorService.submit(task); 
           }   
            
        }   
        
        //把买个任务的结果加起来   
        String result = "2-";  
        for (Future<String> task : tasks) { 
            try {  
                // 如果计算未完成则阻塞  
                result += task.get();  
                
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (ExecutionException e) {  
                e.printStackTrace();  
            }  
        }  
       
        //输出最终的计算结果
        System.out.println(result);
        
        try{   
       
        }catch(Exception e){   
            e.printStackTrace();   
        }finally{   
            //启动一次顺序关闭，执行以前提交的任务，但不接受新任务  
            executorService.shutdown();   
        }   
    }   
}   
  
  
class Result implements Callable<String>{   
  
    /**  
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法， 
     * 则该方法自动在一个线程上执行 
     */   
    public String call() throws Exception {  
        //该返回结果将被Future的get方法得到  
        return "1";   
    }   
}

