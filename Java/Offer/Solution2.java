/**
 * @Author: WuFan
 * @Date: 2019/2/21 16:13
 */

package offer;

import java.util.concurrent.locks.ReentrantLock;

/*
* Java单例模式实现的几种方式
* 多线程并发访问的时候，可能会产生多个实例*/
public class Solution2 {
    private Solution2(){
    }
    private static Solution2 instance = null;
    /*--------------------------------------------------------------------------*/
    /*
    *实现方式1 */
    public static Solution2 getInstance(){
        if(instance == null){
            instance = new Solution2();
        }
        return instance;
    }
    /*--------------------------------------------------------------------------*/
    /*
    * 实现方式2：synchronized*/
    private static Object object = new Object();
    public static Solution2 getInstance2(){

        if(instance == null){
            synchronized (object){
                instance = new Solution2();
            }
        }
        return instance;
    }
    /*--------------------------------------------------------------------------*/
    /*
     * 实现方式3：lock*/
    private static ReentrantLock lock = new ReentrantLock();
    public static Solution2 getInstance3(){
        if(instance == null){
            lock.lock();
            if(instance == null){  //注意这里还要判断下！！
                instance = new Solution2();
            }
            lock.unlock();
        }
        return instance;
    }
    /*--------------------------------------------------------------------------*/
    /*
     * 实现方式4：静态类*/
    public static Nested getNested(){

        return Nested.instance;
    }
    //这个是单例创建的类
    static class Nested{
        private Nested(){
        }
        static Nested instance = new Nested();
    }

}
