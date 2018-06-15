package rechard.learn.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 2. Filter tree structure

class TreeNode {

      List<TreeNode> children;

      Bool display;

      String name;

}

 

给定一棵结构为TreeNode的树

返回过滤后的子树

过滤条件如下：

1. 如果一个节点的所有叶子节点的display 均为false，则该节点被过滤

2. 如果一个节点的任意一个叶子节点的display为true，则该节点被保留

3. 如果一个节点的display为true，但是满足条件1，则该节点也应当被过滤

4. 如果一个节点的display为false，但满足条件2，则该节点应当被保留，并将display改为true

 

例子：

输入

{

   Name: 'root'

   display:true,

   Children: [

         {display: false, name: A},

         {display: true, name: B},

         {

            display: true,

            name: C

            children: [

                     {display: false, name: A}

            ]

          },

    ]

}

输出

{

   Name: 'root'

   display:true,

   Children: [

          {display: true, name: B},

     ]

}
 * @author Rechard
 *
 */

//20:50 22:58
public class TreeNodeFilterDemo {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(false,"root");
		treeNode.children=new ArrayList<TreeNode>();

		treeNode.children.add(new TreeNode(false,"A"));
		treeNode.children.add(new TreeNode(true,"B"));

		TreeNode nodeC = new TreeNode(true,"C");
		nodeC.children=new ArrayList<TreeNode>();
		nodeC.children.add(new TreeNode(false,"C-1"));

		treeNode.children.add(nodeC);
		System.out.println(treeNode.display); 
		System.out.println(treeNode.children.size()); 
		System.out.println("============after================");
		//filter(treeNode,new Stack<TreeNode>());
		filter_recrusive(treeNode,null);
		System.out.println(treeNode.display);  
		System.out.println(treeNode.children.size()); 
	}
	
	
	public static void filter_recrusive(TreeNode treeNode,TreeNode treeNodeParent){
		if(treeNode==null)
			return;
		if(treeNode.children!=null&&!treeNode.children.isEmpty()){
			for(int i=treeNode.children.size()-1;i>=0;i--){
				TreeNode node = treeNode.children.get(i);
				filter_recrusive(node,treeNode);
			}
		}
		if(treeNodeParent!=null){//means now in root node 
			if(!treeNode.display){
				treeNodeParent.children.remove(treeNode);
			}else{
				if(treeNode.children!=null && treeNode.children.isEmpty()){
					treeNodeParent.children.remove(treeNode);
				}
			}
			if(treeNodeParent.children!=null && !treeNodeParent.children.isEmpty()){
				treeNodeParent.display=true;
			}
		}
	}

	public static void filter(TreeNode treeNode,Stack<TreeNode> stack){
		if(treeNode==null)
			return;
		stack.add(treeNode);
		if(treeNode.children!=null&&!treeNode.children.isEmpty()){
			//正序删除会发生问题，倒序删除不会
			for(int i=treeNode.children.size()-1;i>=0;i--){
				TreeNode node = treeNode.children.get(i);
				filter(node,stack);
			}
		}
		TreeNode node = stack.pop();
		TreeNode nodeParent = node;
		if(!stack.isEmpty()){
			nodeParent =  stack.peek();
		}
		if(!node.display){
			nodeParent.children.remove(node);
		}else{
			if(node.children!=null && node.children.isEmpty()){
				nodeParent.children.remove(node);
			}
		}
		if(nodeParent.children!=null && !nodeParent.children.isEmpty()){
			nodeParent.display=true;
		}
	}

	/*public static void filter(TreeNode treeNode,List childrenList){
		if(treeNode==null)
			return;

		if(!treeNode.display){
			if(treeNode.children!=null&&!treeNode.children.isEmpty()){
				boolean allChildNodeDisplayFalse = true;
				Iterator<TreeNode> it = treeNode.children.iterator();
				while(it.hasNext()){
					TreeNode node = it.next();
					if(node.display){
						allChildNodeDisplayFalse = false;
					}
					if(node.children!=null)
						filter(node,node.children);
					else
						it.remove();
				}
				if(allChildNodeDisplayFalse)
					childrenList.remove(treeNode);
				else
					treeNode.display=true;//如果一个节点的display为false，但满足条件2，则该节点应当被保留，并将display改为true
			}else{
				childrenList.remove(treeNode);
			}

		}else{//if root is true
			if(treeNode.children!=null&&!treeNode.children.isEmpty()){
				boolean allChildNodeDisplayFalse =true; 
				Iterator<TreeNode> it = treeNode.children.iterator();
				while(it.hasNext()){
					TreeNode node = it.next();
					if(node.display){
						allChildNodeDisplayFalse = false;
					}
					if(node.children!=null)
						filter(node,node.children);
					else
						it.remove();
				}
				if(allChildNodeDisplayFalse)//all child display false, remove this node
					childrenList.remove(treeNode);
			}
		}
	}*/

}
