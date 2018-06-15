package rechard.interview.ringcentral.first;

/**
 * 
 * Given binary tree [3,9,20,null,null,15,7],

    3

   / \

  9  20

    /  \

   15   7
   
   思路是每一层的数目是 2的n次方个，那么遍历的时候其实只要步长是2的n次方
   然后打印出来即可
 * 
 * @author Rechard
 *
 */
public class InterviewTest {

	public static void main(String[] args) {
		String[] treeNodes= {"3","9","20",null,null,"15","7",null,null,null,null,"20","21","22","23"}; 
		travel(treeNodes);
	}

	public static void travel(String[] treeNodes){
		if(treeNodes==null)
			return;
		int step=0;
		int levelBegin=0;
		int levelEnd=0;
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append("\r\n");
		for(int i=0;i<treeNodes.length;i=levelEnd){
			levelBegin=i;
			if(step==0)
				step=1;
			else
				step=step<<1;
			levelEnd=levelBegin+step;
			sb.append("[");
			for(int j=levelBegin;j<levelEnd;j++){
				if(treeNodes[j]!=null){
					sb.append(treeNodes[j]);
					if(j<levelEnd-1)
						sb.append(",");
				}
			}
			sb.append("]");
			sb.append("\r\n");
		}
		sb.append("]");
		System.out.println(sb.toString());
	}


}
