//定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。 
//
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.min();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.min();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// 各函数的调用总次数不超过 20000 次 
// 
//
// 
//
// 注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/ 
// Related Topics 栈 设计

package leetcode.editor.cn;

import java.util.Stack;

class BaoHanMinhanShuDeZhanLcof{
      public static void main(String[] args) {
           MinStack solution = new BaoHanMinhanShuDeZhanLcof().new MinStack();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

/**
 *
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.min();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.min();   --> 返回 -2.
 */
// -3 0 -4
// min top
// -3 -3    -3 0   -4 -4
// min()
     /** initialize your data structure here. */
    Stack<Integer> stack=null;
    public MinStack() {
        stack=new Stack();
    }
    
    public void push(int x) {
        if(!stack.isEmpty()) {
            int min=this.min();
            stack.push(min<x?min:x);
            stack.push(x);
        }else {
            stack.push(x);
            stack.push(x);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty())
           stack.pop();
        if(!stack.isEmpty())
           stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        int cur=stack.pop();
        int min=stack.peek();
        stack.push(cur);
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//leetcode submit region end(Prohibit modification and deletion)

}