package rechard.learn.leecode;

public class LC365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x<y){
            return canMeasureWater(y,x,z);
        }
        if(z>x+y) return false;
        if(z==x+y || z==x || z==y) return true;
        if((x==0||y==0)&&(z!=x+y)) return false;
        int left=x-y;
        while(left>0){
            if(z==left) return true;
            if(x+left==z||y+left==z) return true;
            if(x-(y-left)==z) return true;
            if(left>=y){
                left=left-y;
            }else{
                left=y-left;
                if(x-left==z || y+left==z) return true;
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println( new LC365().canMeasureWater(34,5,6) );
    }
}
