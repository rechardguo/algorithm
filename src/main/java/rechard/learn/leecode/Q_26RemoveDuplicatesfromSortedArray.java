package rechard.learn.leecode;

public class Q_26RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int i=0,j=1;
        while(j<nums.length){
            if(nums[i]!=nums[j]){
                nums[i+1]=nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }
}
