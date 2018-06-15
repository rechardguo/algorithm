package rechard.interview.ringcentral.second;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

public class Test {

	private static List<Extension> extensions = new ArrayList<Extension>();
	@Before
	public void setUp() throws Exception {
		Extension e1 = new Extension();
		e1.setFirstName("A");
		e1.setLastName("ccc");
		e1.setExt("User");
		
		Extension e2 = new Extension();
		e2.setFirstName("A");
		e2.setLastName("bbb");
		e2.setExt("Dept");
		
		/*Extension e3 = new Extension();
		e3.setFirstName("A");
		e3.setLastName("aaa");
		e3.setExt("AO");
		
		Extension e4 = new Extension();
		e4.setFirstName("A");
		e4.setLastName("ddd");
		e4.setExt("TMO");
		
		Extension e5 = new Extension();
		e5.setFirstName("A");
		e5.setExt("Other");*/
		
		
		extensions.add(e1);
		extensions.add(e2);
		/*extensions.add(e3);
		extensions.add(e4);
		extensions.add(e5);*/
    }
	
	@org.junit.Test
	public void testSortByName(){
		Extension unexp = extensions.get(0);
		Extension expect =  extensions.get(1);
		List<Extension> result = Utils.sortByName(extensions);
		Assert.assertEquals(expect, result.get(0));
		Assert.assertNotEquals(unexp, result.get(0));
	
		Extension e5 = new Extension();
		e5.setFirstName("A");
		e5.setExt("Other");
		extensions.add(e5);
		result = Utils.sortByName(extensions);
		Assert.assertEquals("Other", result.get(2).getExt());
	}
	@org.junit.Test
	public void testSortByExtType(){
		List<Extension> extensions = new ArrayList<Extension>();
		Extension e1 = new Extension();
		e1.setFirstName("A");
		e1.setLastName("ccc");
		e1.setExt("Dept");
		Extension e2 = new Extension();
		e2.setFirstName("A");
		e2.setLastName("ccc");
		e2.setExt("User");
		extensions.add(e2);
		extensions.add(e1);
		Utils.sortByExtType(extensions);
		Assert.assertEquals("User",extensions.get(0).getExt());
	}
	@org.junit.Test
	public void testSumByQuarter(){
		List<SaleItem> saleItems = new ArrayList<SaleItem>();
		SaleItem item = null;
		for(int i=1;i<=12;i++){
			item = new SaleItem();
			item.setMonth(i);
			item.setSaleNumbers(i);
			saleItems.add(item);
		}
		List<QuarterSalesItem> list = Utils.sumByQuarter(saleItems);
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			QuarterSalesItem quarterSalesItem = (QuarterSalesItem) iterator.next();
			System.out.println(quarterSalesItem.getQuarter()+":"+quarterSalesItem.getTotal());
		}
	}
	@org.junit.Test
	public void testMaxByQuarter(){
		List<SaleItem> saleItems = new ArrayList<SaleItem>();
		SaleItem item = null;
		for(int i=1;i<=12;i++){
			item = new SaleItem();
			item.setMonth(i);
			item.setSaleNumbers(i);
			saleItems.add(item);
		}
		List<QuarterSalesItem> list = Utils.maxByQuarter(saleItems);
		Assert.assertEquals(4,list.get(0).getQuarter());
	}
	@org.junit.Test
	public void testGetUnUsedKeys(){
		int [] allKeys= new int[]{0,1,2,3,4,5,6,7,8,9};
		int [] usedKeys= new int[]{3,4,9};
		int[] unUsedkeys = Utils.getUnUsedKeys(allKeys, usedKeys);
		for (int i = 0; i < unUsedkeys.length; i++) {
			System.out.println(unUsedkeys[i]);
		}
	}
}
