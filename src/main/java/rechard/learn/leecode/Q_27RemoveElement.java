package rechard.learn.leecode;

/**
 * 思路很简单，但是边界条件缺需要考虑的比较周到
 */
public class Q_27RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if(nums==null||nums.length==0)return 0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]==val){
                while(nums[j]==val && j>i){
                    j--;
                }
                if(j==i){
                    return nums[i]==val?i:i+1;
                }else{
                    nums[i]=nums[j];
                    nums[j--]=val;
                }

            }
            i++;
        }
        return nums[i]==val?i:i+1;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{4,5},5));
    }
}
