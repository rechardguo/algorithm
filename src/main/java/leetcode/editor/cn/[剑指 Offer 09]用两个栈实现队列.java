//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 ) 
//
// 
//
// 示例 1： 
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
// 
//
// 示例 2： 
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
// 
//
// 提示： 
//
// 
// 1 <= values <= 10000 
// 最多会对 appendTail、deleteHead 进行 10000 次调用 
// 
// Related Topics 栈 设计

package leetcode.editor.cn;

import java.util.Stack;

class YongLiangGeZhanShiXianDuiLieLcof{
      public static void main(String[] args) {

      }
 //leetcode submit region begin(Prohibit modification and deletion)
class CQueue {
     Stack<Integer> stack1=new Stack();
     Stack<Integer> stack2=new Stack();
    public CQueue() {

    }
     //123
     //321 tail
     //appendTail 和 deleteHead
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(!stack2.isEmpty()){
           return stack2.pop();
        }else{
            while(stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            if(!stack2.isEmpty())
             return stack2.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)

}