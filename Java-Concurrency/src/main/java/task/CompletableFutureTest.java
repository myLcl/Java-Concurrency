package task;

import java.util.concurrent.CompletableFuture;

/**
 * 测试完成时间
 * Created by conglin.liu on 2017/9/10.
 */
public class CompletableFutureTest implements Runnable{
    CompletableFuture<Integer> re = null;

    public CompletableFutureTest(CompletableFuture<Integer> re) {
        this.re = re;
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = re.get() * re.get();
        } catch (Exception e) {
        }
        System.out.println(myRe);
    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture<Integer>();
        new Thread(new CompletableFutureTest(future)).start();
        // 模拟长时间的计算过程
        Thread.sleep(1000);
        // 告知完成结果
        future.complete(60);
    }
}
