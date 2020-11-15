package rechard.learn.jdk;

import java.util.concurrent.CompletableFuture;

/**
 * 这个demo演示了CompletableFuture的使用
 *
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws InterruptedException {
        compeatableUse();
    }

    /**
     * CompletableFuture 从2个线程里的拿到结果，谁先拿到就返回谁的
     */
    public static void compeatableUse() throws InterruptedException {
        QueryTask task=new QueryTask();
        CompletableFuture<Integer> cfQueryCode1=CompletableFuture.supplyAsync(()->{
            return task.queryCode("cnsy");
        });

        CompletableFuture<Integer> cfQueryCode2=CompletableFuture.supplyAsync(()->{
            return task.queryCode("cnsy");
        });
        CompletableFuture<Object> cfQueryCode=CompletableFuture.anyOf(cfQueryCode1,cfQueryCode2);

        CompletableFuture cfQueryPrice1= cfQueryCode.thenApplyAsync(code->{
           return task.queryPrice((Integer)code);
        });

        CompletableFuture cfQueryPrice2= cfQueryCode.thenApplyAsync(code->{
            return task.queryPrice((Integer)code);
        });
        CompletableFuture<Object> cfQueryPrice=CompletableFuture.anyOf(cfQueryPrice1,cfQueryPrice2);

        cfQueryPrice.thenAccept(result->{
            System.out.println("fetch price is:"+result);
        });

        Thread.sleep(200);

    }

    static class QueryTask {
        public int queryCode(String name) {
            try {
                Thread.sleep((long) (Math.random()/100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1000;
        }

        public double queryPrice(int code){
            try {
                Thread.sleep((long) (Math.random()/100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 5 + Math.random() * 20;
        }
    }
    /**
     * 简单的使用，主要用于类似前端的 subscribe(...)
     * @throws InterruptedException
     */
    public static void simpleuse() throws InterruptedException {
        CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            if (Math.random() < 0.3) {
                throw new RuntimeException("fetch price failed!");
            }
            return 5 + Math.random() * 20;
        }).thenAccept(result->{
            System.out.println("获取价格成功："+result);
        }).exceptionally(e->{
            System.err.println(e.getMessage());
            return null;
        });
        Thread.sleep(200);
    }
}
