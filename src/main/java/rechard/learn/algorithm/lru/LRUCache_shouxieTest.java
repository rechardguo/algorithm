package rechard.learn.algorithm.lru;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class LRUCache_shouxieTest {

    @Test
    public void check(){
        LRUCache_shouxie lruCache=new LRUCache_shouxie(5);

        Assert.assertEquals("",lruCache.print());
        for (int i = 1; i <= 5; i++) {
            lruCache.put(i,i);
        }
        Assert.assertEquals("5,4,3,2,1",lruCache.print());
        lruCache.put(6,6);
        Assert.assertEquals("6,5,4,3,2",lruCache.print());

        lruCache.put(6,7);
        Assert.assertEquals("7,5,4,3,2",lruCache.print());
        lruCache.put(2,8);
        Assert.assertEquals("8,7,5,4,3",lruCache.print());
        lruCache.put(5,9);
        Assert.assertEquals("9,8,7,4,3",lruCache.print());
        lruCache.put(4,10);
        Assert.assertEquals("10,9,8,7,3",lruCache.print());
        lruCache.put(3,11);
        Assert.assertEquals("11,10,9,8,7",lruCache.print());
        lruCache.put(12,12);
        Assert.assertEquals("12," +
                "11,10,9,8",lruCache.print());
    }

}
