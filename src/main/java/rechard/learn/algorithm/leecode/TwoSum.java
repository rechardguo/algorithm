package rechard.learn.algorithm.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class TwoSum {

    public int[] towSum(int[] nums, int target){

        Map<Integer,Integer> m =new HashMap();
        for (int i = 0; i <nums.length ; i++) {
           int expect=target-nums[i];
           if(m.get(expect)==null){
               m.put(nums[i],i);
           }else{
               return new int[]{i,m.get(expect)};
           }
        }
        throw new IllegalArgumentException("number "+target+" can not find selution ");
    }
}
