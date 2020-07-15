package rechard.learn.leecode.回溯算法;

import java.util.HashMap;
import java.util.Map;

public class LC45 {
    static class Solution {
        Map<Integer,Integer> memo=new HashMap();
        public int jump(int[] nums){
            if(nums==null||nums.length<=1) return 0;
            return dfs(nums,0,0);
        }
        public int dfs(int[] nums,int pos,int jump) {
            if(memo.get(pos)!=null)
                return memo.get(pos);

            if(pos>=nums.length-1)
                return jump;
            int min=Integer.MAX_VALUE;
            for(int i=pos+1;i<=(pos+nums[pos]);i++){
                min=Math.min(min,dfs(nums,i,jump+1));
            }
            memo.put(pos,min);
            return min;
        }

    }

    public static void main(String[] args) {
       int minStep=new Solution().jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5});
        System.out.println(minStep);
    }

}
