package rechard.learn.sgu.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环
 */
public class YSF {

    public static void main(String[] args) {
        System.out.println(last(5,1,1));
    }


    public static int last(int total,int start,int count){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < total ; i++) {
            list.add(i+1);
        }
        int i=(start-1)%list.size();
        while(list.size()>1){
            int c=0;
            while(c<count) {
                i=(i+1)%list.size();
                c++;
            }
            System.out.printf("%d\t",list.remove(i));
        }
        return list.get(0);
    }

}


