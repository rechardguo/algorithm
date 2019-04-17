package rechard.company.topic.ringcentral.second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utils {

	/**
	 * Question1, sort by firstName + lastName + ext, 
	 * if firstName is the same then sort by lastName and
	 * ext, please note lastName and ext can be empty 
	 * string or null.
	 *
	 **/
	public static List<Extension> sortByName(List<Extension> extensions) {
		if(extensions==null || extensions.isEmpty())
			return extensions;
		Collections.sort(extensions, new Comparator<Extension>() {
			public int compare(Extension e1, Extension e2) {
				int result = 0;
				//from question description firstName can not empty or null
				if( (result = e2.getFirstName().compareTo(e1.getFirstName()))==0){
					if(e1.getLastName()!=null && e1.getExt()!=null && e2.getLastName()!=null && e2.getExt()!=null){
						result = (e1.getLastName()+e1.getExt()).compareTo(e2.getLastName()+e2.getExt());
					}else if(e1.getLastName()!=null && e1.getExt()!=null){
						result = -1;
					}else if(e2.getLastName()!=null && e2.getExt()!=null){
						result = 1;
					}
				}
				return result;
			}
		});
		return extensions;
	}


	/**
	 * Question2, sort extType, extType is a string and can
	 * be "User", "Dept", "AO", "TMO", "Other",
	 * sort by User > Dept > AO > TMO > Other;
	 *
	 **/
	public static List<Extension> sortByExtType(List<Extension> extensions) {

		final Map<String,Integer> indexMap = new HashMap<String,Integer>();
		indexMap.put("User", 1);
		indexMap.put("Dept", 2);
		indexMap.put("AO", 3);
		indexMap.put("TMO", 4);
		indexMap.put("Other", 5);
		if(extensions==null || extensions.isEmpty())
			return extensions;
		Collections.sort(extensions, new Comparator<Extension>() {
			public int compare(Extension e1, Extension e2) {
				//what if ext is null logic?
				Integer index1 = indexMap.get(e1.getExt());
				if(index1==null)
					return  -1;
				Integer index2 = indexMap.get(e2.getExt());
				if(index2==null)
					return 1;
				return index1.compareTo(index2);
			}
		});
		return extensions;
	}

	/**
	 * Question3, sum all sales items by quarter
	 *
	 *大意了，没想到这里。
	 **/
	public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
		if(saleItems==null)
			return null;
		List<QuarterSalesItem>  list = new ArrayList<QuarterSalesItem>();
		QuarterSalesItem q = null;
		for(int i=1;i<=4;i++){
			q = new QuarterSalesItem();
			q.setQuarter(i);
			list.add(q);
		}
		Iterator<SaleItem>  it = saleItems.iterator();
		while(it.hasNext()){
			SaleItem saleItem = it.next();
			q = list.get((saleItem.getMonth()-1)/3); 
			q.setTotal(q.getTotal()+saleItem.getSaleNumbers());
		}
		return list;
	}

	/**
	 * Question4, max all sales items by quarter
	 *
	 * 
	 **/
	public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
		//my understand is return max sales amount by quater
		List<QuarterSalesItem> list = sumByQuarter(saleItems);
		QuarterSalesItem max = list.get(0);
		QuarterSalesItem qsi = null;
		for(int i=1;i<list.size();i++){
			qsi = list.get(i);
			if(qsi.getTotal()>max.getTotal())
				max =qsi;
		}
		List<QuarterSalesItem> maxList = new ArrayList<QuarterSalesItem>();
		maxList.add(max);
		return maxList;
	}

	//Question5
	/**
	 * We have all Keys: 0-9;
	 * usedKeys is an array to store all used keys like :[2,3,4];
	 * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,]
	 */

	public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
		if(allKeys==null||allKeys.length==0) return allKeys;
		if(usedKeys==null||usedKeys.length==0) return allKeys;
		Map<Integer,Integer> map =new LinkedHashMap<Integer,Integer>();
		for (int i = 0; i < usedKeys.length; i++) {
			map.put(usedKeys[i], usedKeys[i]);
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int j=0;j<allKeys.length;j++){
			if(!map.containsKey(allKeys[j])){
				list.add(allKeys[j]);
			}
		}
		int[] unUsedKeys = new int[list.size()];
		Iterator<Integer> iterator = list.iterator();
		int index=0;
		while(iterator.hasNext()){
			unUsedKeys[index++]=iterator.next();
		}
		return unUsedKeys;
	}
	
	public static void main(String[]args){
		//A<AC
		System.out.println((-1 << 29) | 0);
	}

}
