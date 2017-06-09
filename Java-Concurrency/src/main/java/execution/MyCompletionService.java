package execution;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试CompletionService获得任务结果集
 */
public class MyCompletionService {
	public static void main(String[] args){   
		ExecutorService executorService = Executors.newCachedThreadPool(); 
		
		//构造函数传入一个Executor
        CompletionService<String> completionService = new ExecutorCompletionService<String>(executorService);  
        
        //创建10个任务并执行   
        for (int i = 0; i < 10; i++){   
           if(!executorService.isShutdown()) {
        	   //由CompletionService执行任务
        	   completionService.submit(new Result0());
           }   
            
        }   
        
        //把多个任务的结果加起来   
        String result = "2_";  
            try {  
	            for (int i = 0; i < 10; i++) {
	            	// 如果任务未完成，则该任务的take()会阻塞
	            	String s = completionService.take().get();
	            	result += s;  
				}	
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (ExecutionException e) {  
                e.printStackTrace();  
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
  
class Result0 implements Callable<String>{   
  
    /**  
     * 任务的具体过程，一旦任务传给ExecutorService的submit方法， 
     * 则该方法自动在一个线程上执行 
     */   
    public String call() throws Exception {  
        //该返回结果将被Future的get方法得到  
        return "1";   
    }   
}
