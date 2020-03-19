package rechard.learn.leecode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LC409 {
    public int longestPalindrome(String s) {
        Map<Integer,Integer> counter= s.chars().boxed().collect(Collectors.toMap(k->k, v->1,Integer::sum));
        int res= (int) counter.values().stream().mapToInt(i->i-(i&1)).sum();
        return res<s.length()?res+1:res;
    }
}
