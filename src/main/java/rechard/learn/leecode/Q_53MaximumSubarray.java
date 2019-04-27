package rechard.learn.leecode;

public class Q_53MaximumSubarray {

    //高，妙
    //动态规划
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int finalMax = nums[0];
        for(int i=1; i<nums.length; i++){
            currSum += nums[i];
            currSum = Math.max(currSum, nums[i]);
            finalMax = Math.max(currSum, finalMax);
        }
        return finalMax;
    }

    public int maxSubArray_error(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        int tmp=nums[0];
        int max=tmp;
        int i=0,j=1;
        while(j<nums.length){
            tmp+=nums[j];
            if(nums[j]<0){
                do{
                    tmp=tmp-nums[i];
                }while(nums[++i]<0&&i<j);
            }
            max=Math.max(max,tmp);
            max=Math.max(max,nums[j]);
            j++;
        }
        while(i<nums.length-1){
            tmp-=nums[i];
            max=Math.max(max,tmp);
            i++;
        }

        return max;
    }
}
