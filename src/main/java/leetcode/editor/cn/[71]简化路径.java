//以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。 
//
// 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成
//部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径 
//
// 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表
//示绝对路径的最短字符串。 
//
// 
//
// 示例 1： 
//
// 输入："/home/"
//输出："/home"
//解释：注意，最后一个目录名后面没有斜杠。
// 
//
// 示例 2： 
//
// 输入："/../"
//输出："/"
//解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
// 
//
// 示例 3： 
//
// 输入："/home//foo/"
//输出："/home/foo"
//解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
// 
//
// 示例 4： 
//
// 输入："/a/./b/../../c/"
//输出："/c"
// 
//
// 示例 5： 
//
// 输入："/a/../../b/../c//.//"
//输出："/c"
// 
//
// 示例 6： 
//
// 输入："/a//b////c/d//././/.."
//输出："/a/b/c" 
// Related Topics 栈 字符串

package leetcode.editor.cn;

import java.util.LinkedList;

/**
 * 解题思路：
 * 使用 /分隔 字符串成字符串数组
 * 使用LinekdList 是由于 LinekdList可以当队列也可以当列表
 * 遇到 .. 就弹出
 * 遇到 . 和 空就跳过
 *
 * 最后拼接在一起的时候要使用pollLast, 把LinkedList当成队列来使用
 * poll()是从队首取出，相当于pop()
 * 从队尾取则是pollLast()
 */
class SimplifyPath{
      public static void main(String[] args) {
           Solution solution = new SimplifyPath().new Solution();
      }
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String simplifyPath(String path) {
        String[] info = path.split("/");
        LinkedList ll=new LinkedList();
        for(String str:info){
            if(str.equals("..")){
                if(!ll.isEmpty())
                   ll.pop();
            }else if(str.equals(".") || str.equals("")) continue;
            else{
                ll.push(str);
            }
        }

        StringBuilder builder=new StringBuilder("/");
        while(!ll.isEmpty()){
            builder.append(ll.pollLast());//从队尾获取
            if(!ll.isEmpty()) builder.append("/");
        }
       return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}