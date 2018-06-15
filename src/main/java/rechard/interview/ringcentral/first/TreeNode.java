package rechard.interview.ringcentral.first;

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
