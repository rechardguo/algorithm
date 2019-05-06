package rechard.learn.leecode;

/**
 * 有n个盒子排成一行，每个盒子上面有一个数字a[i]，表示最多能向右跳a[i]个盒子；
 小明站在左边第一个盒子，请问能否到达最右边的盒子？
 比如说：[1, 2, 3, 0, 4] 可以到达第5个盒子；
 [3, 2, 1, 0, 4] 无法到达第5个盒子；
 */
public class JumpBox {


    public static void main(String[] args) {
        int[] nums=new int []{2,0,9,0,1,0,0,1};
        System.out.println(new JumpBox().func(nums));
    }

    public boolean func(int [] nums){
        if(nums==null||nums.length==0)return false;
        if(nums.length==1)return true;
        return func_0(nums,nums.length-1);
    }

    private boolean func_0(int [] nums,int targetIndex){
        if(targetIndex==0)
            return true;
        boolean flag=false;
        for(int i=targetIndex-1;i>=0;i--){
            if(canReach(i,nums,targetIndex)){
                flag=flag||func_0(nums,i);
            }
        }
        return flag;
    }

    private boolean canReach(int fromIndex,int [] nums,int targetIndex){
       return nums[fromIndex]>=(targetIndex-fromIndex);
    }
}
