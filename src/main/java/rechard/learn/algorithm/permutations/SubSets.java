package rechard.learn.algorithm.permutations;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3};
        List<List<Integer>> result = new SubSets().subsets(nums);
        result.forEach(l->{
            l.forEach(n-> System.out.print(n));
            System.out.println("");
           }
        );
    }
    public List<List<Integer>> subsets(int [] nums){
        List<List<Integer>> list= new ArrayList<>();
        backTrace(list,new ArrayList<Integer>(),0,nums);
        return list;
    }
    public void backTrace( List<List<Integer>> list,List<Integer> tmpList,int index,int [] nums){
        if(tmpList.size()<=nums.length)
            list.add(tmpList);
        else if(tmpList.size()>nums.length)
            return;


        for (int i = index; i < nums.length; i++) {
            List<Integer> tmpList2=new ArrayList<>();
            tmpList2.addAll(tmpList);
            tmpList2.add(nums[i]);
            backTrace(list,tmpList2,index+1,nums);
        }
    }
}
