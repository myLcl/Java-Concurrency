package basic;

/**
 * 测试关键字:volatile
 * <p>
 *  在主线程中修改共享变量,另开启一个线程获的共享变量的值
 */
public class VolatileTest implements Runnable {
     volatile boolean flag; //线程循环条件

    public void run() {
        int i = 0;
        while (!flag) {
            System.out.println(i++);
        }

        System.out.println("volatile"); //若打印,则说明volatile修饰的共享变量是内存可见的
    }

    public static void main(String[] args) {
        VolatileTest v = new VolatileTest();
        Thread t = new Thread(v);
        t.start();

        try {
            Thread.sleep(100);
            v.flag = true;
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        System.out.println(v.flag);
    }

}  
