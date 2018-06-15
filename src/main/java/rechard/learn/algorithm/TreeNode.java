package rechard.learn.algorithm;

import java.util.List;

public class TreeNode {
	List<TreeNode> children;
    boolean display;
    String name;
    
    public TreeNode(boolean display,String name){
    	this.display=display;
    	this.name=name;
    }
}
