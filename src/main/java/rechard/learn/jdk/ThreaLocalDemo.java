package rechard.learn.jdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 使用线程池，并且使用threadlocal就会有问题
 *
 * 客户端请求到达jboss或tomcat后，其实使用从jboss或tomcat的线程池里拿到
 * 一个线程去处理，如果线程的上下文没被清除的话也是有问题
 *
 */
public class ThreaLocalDemo {

    public static void main(String[] args) {
        ExecutorService service=Executors.newFixedThreadPool(2);

        for (int i=0;i<10;i++) {
            final String index=String.valueOf(i);
            Future future= service.submit(()->{
               if(Context.get()==null){
                   Context.put(index);
               }
                System.out.println(Context.get());
               //如果没有这个清楚，就会发生问题
               Context.clear();
            });
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    static class Context{
        static  ThreadLocal<String> tl=new ThreadLocal();
        public static String get(){
            return tl.get();
        }
        public static void put(String threadName){
            tl.set(threadName);
        }
        public static  void clear(){
            tl.remove();
        }

    }
}
