package basic.createThread;

import org.junit.Test;

/**
 * 继承Thread
 * Created by conglin.liu on 2017/9/6.
 */
public class ExtendsThread extends Thread{

    /**
     * 创建线程
     */
    @Test
    public void createThread() {
        ExtendsThread extendsThread01 = new ExtendsThread();
        new Thread(extendsThread01).start();
    }

    @Override
    public void run() {
        System.out.println(1);
    }
}
