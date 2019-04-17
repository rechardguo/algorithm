package rechard.learn.algorithm.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * 求解出所有的有效的数字组合
 */
public class PossibleNumberComposite {

    public static void main(String[] args) {
        int[] p=new int[]{2,3,5};
        List<List<Integer>> r=new PossibleNumberComposite().getAll(p,8);
        for (List<Integer> l:r) {
            for (Integer i:l)
                System.out.print(i+",");

            System.out.println("");
        }
    }

    public List<List<Integer>> getAll(int[] arr,int target){
        List<List<Integer>> possibleList=new ArrayList<>();
        backtrace(possibleList, new ArrayList<Integer>(), arr, target);
        return possibleList;
    }


    private void backtrace(List<List<Integer>> possibleList, List<Integer> tempList,int[] arr,int target){
        if(sum(tempList)==target) {
            possibleList.add(tempList);
            return;
        }else if(sum(tempList)>=target){
            return;
        }

        for(int i=0;i<arr.length;i++){
            List l=new ArrayList<Integer>();
            l.add(arr[i]);
            l.addAll(tempList);
            backtrace(possibleList,l,arr,target);
        }

    }

    private int sum(List<Integer> tempList) {
        Integer sum=0;

        for (Integer i :tempList){
            sum+=i;
        }
        return sum;
    }

}
