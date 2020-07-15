package rechard.learn.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * 滑动窗口来的解题思路
 *
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 */
public class LCMST57 {
    public int[][] findContinuousSequence(int target) {
        int r=target/2+target%2;
        int i=1;
        int j=1;
        int sum=1;
        List<int[]> list=new ArrayList();
        while(i<r){
            if(sum<target){
                j++;
                sum+=j;
            }else if(sum>target){
                sum-=i;
                i++;
            }else{
                int[] ans=new int[j-i+1];
                for(int in=0,y=i;in<ans.length;in++){
                    ans[in]=y++;
                }
                list.add(ans);
                sum-=i;
                i++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
