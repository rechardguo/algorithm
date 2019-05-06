package rechard.learn.leecode;

/**
 * 有n个盒子排成一行，每个盒子上面有一个数字a[i]，表示最多能向右跳a[i]个盒子；
 小明站在左边第一个盒子，请问能否到达最右边的盒子？
 比如说：[1, 2, 3, 0, 4] 可以到达第5个盒子；
 [3, 2, 1, 0, 4] 无法到达第5个盒子；
 找到最小能到达的跳跃路径

难度为hard
 Runtime: 117 ms, faster than 32.44% of Java online submissions for Jump Game II.
 Memory Usage: 41.7 MB, less than 9.60% of Java online submissions for Jump Game II.
 */
public class Q_45JumpGameII {



    public static void main(String[] args) {
        int[] nums=new int []{10,0,9,1,1,1,1,1};
        System.out.println(new Q_45JumpGameII().func(nums));
    }

    public int func(int [] nums){
        if(nums==null||nums.length==0) throw new IllegalArgumentException("nums can not be null or empty!");
        if(nums.length==1)return 0;
        int step=0;
        int  targetIndex=nums.length-1;
        while((targetIndex=maxReachIndex(nums,targetIndex))>0){
           step++;
        }
       if(targetIndex==0)//正常的情况下一定是0
           return step+1;
        else//-1代表找不到了
           throw new IllegalArgumentException("can not find jump index way");
    }

    /**
     *
     * @param nums
     * @param targetIndex 目标index
     * @return 从右往左找，找到能跳到 目标index的最左边的值，如果不能找到能跳到的index则返回-1
     */
    private int maxReachIndex(int [] nums, int targetIndex){
        if(targetIndex==0)return 0;
        int maxReachIndex=targetIndex;
        boolean flag=false;
        for(int i=targetIndex-1;i>=0;i--){
            if(canReach(i,nums,targetIndex)){
                maxReachIndex=i;
            }
        }
        return maxReachIndex==targetIndex?-1:maxReachIndex;
    }

    private boolean canReach(int fromIndex,int [] nums,int targetIndex){
        return nums[fromIndex]>=(targetIndex-fromIndex);
    }
}
