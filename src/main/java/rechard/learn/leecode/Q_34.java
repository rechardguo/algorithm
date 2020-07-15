package rechard.learn.leecode;

public class Q_34 {

    public int[] searchRange(int[] nums, int target) {

        return searchRange0(nums,target,new int[]{0,nums.length-1});
    }

    private int[] searchRange0(int[] nums, int target,int range[]) {
        int left=range[0],right=range[1];
        if(nums==null) {
            return new int[]{-1,-1};
        }
        if(left==right) {
            return range;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
               int[] leftArr=searchRange0(nums,target,new int[]{left,mid});
               int[] rightArr=searchRange0(nums,target,new int[]{mid,right});

               return new int[]{leftArr[0],rightArr[1]};
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr=new int[]{5,7,7,8,8,10};
        int[] result=new Q_34().searchRange(arr,8);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

}
