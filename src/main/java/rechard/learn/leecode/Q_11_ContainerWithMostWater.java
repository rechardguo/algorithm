package rechard.learn.leecode;

public class Q_11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height==null)
            return 0;
        int max=0;
        for(int i=0;i<height.length-1;i++){
            if(i==0||height[i]>height[i-1]){
                for(int j=i+1;j<height.length;j++){
                    int s=(j-i)*Math.min(height[i],height[j]);
                    if(s>max){
                        max=s;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q_11_ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
