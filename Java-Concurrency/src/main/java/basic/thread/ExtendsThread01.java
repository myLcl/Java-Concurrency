package basic.thread;

import org.junit.Test;

/**
 * 继承Thread
 * Created by conglin.liu on 2017/9/6.
 */
public class ExtendsThread01 extends Thread{

    /**
     * 创建线程
     */
    @Test
    public void createThread() {
        ExtendsThread01 extendsThread01 = new ExtendsThread01();
        new Thread(extendsThread01).start();
    }

    @Override
    public void run() {
        System.out.println(1);
    }
}
