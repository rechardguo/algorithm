package rechard.learn.algorithm.lru;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 实现lru算法
 *
 * lru latest resent use
 *
 * 最近最少使用，这一般用于淘汰策略，例如redis
 *
 * 比如 缓存了 1，2，3，4，5  从左到右分别是最经常访问到最不经常访问，这时候如果插入6，而
 * 缓存最大只能存5个，需要 选1个淘汰，这时候就把5淘汰，再把6插入，变成6,1,2,3,4
 *
 * 如果访问了下2，则2需要提前，变成2，6，1，3，4
 *
 *
 *最简单的实现通过jdk的LinkedHashMap来实现
 */
public class LRUCache {

    @Test
    public void testLinkedHashMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(5, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                //当LinkHashMap的容量大于等于5的时候,再插入就移除旧的元素
                return this.size() >= 5;
            }
        };
        map.put("aa", "bb");
        map.put("cc", "dd");
        map.put("ee", "ff");
        map.put("gg", "hh");
        print(map);
        map.get("cc");
        System.out.println("===================================");
        print(map);

        map.get("ee");
        map.get("aa");
        System.out.println("====================================");
        map.put("ss","oo");
        print(map);
    }

    void print(LinkedHashMap<String, String> source) {
        source.keySet().iterator().forEachRemaining(System.out::println);
    }
}
