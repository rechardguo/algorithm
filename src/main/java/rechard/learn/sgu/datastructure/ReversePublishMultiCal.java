package rechard.learn.sgu.datastructure;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Stack;

public class ReversePublishMultiCal {

    public static float cal(String exp){
        if(exp==null||exp.length()==0) throw new IllegalArgumentException("表达式为空");
        ArrayList midExp=midExpression(exp);
        System.out.println("打印出中缀表达式");
        printExp(midExp);
        //ArrayList sufExp=sufExpression(midExp);
        //System.out.println("打印出后缀表达式");
        //printExp(sufExp);
        //return cal(sufExp);
        return 0;
    }


    /**
     * 打印出表达式
     * @param exp
     */
    public static void printExp(ArrayList exp){
        Optional.of(exp).ifPresent(e->{
            e.stream().forEach(System.out::print);
        });
    }

    /**
     * 后缀表达式计算的出结果
     *
     * 规则:
     *
     *
     * @param sufExp
     * @return
     */
    public static float cal(ArrayList sufExp){
        float res=0;



        return res;
    }

    /**
     *
     * @param midExp 中缀表达式转后缀表达式
     *
     *  规则
     *  1. 遇到数字压入
     *  2. 遇到(,压入
     *  3. 遇到),弹出知道(
     *  4.如果遇到操作符级别的低于stack.peek()的，则不断的stack.pop()直到遇到大于或等于遇到操作符
     *  5.最后如果stack不为空则全部弹出
     *
     * @return
     */
    public static ArrayList sufExpression(ArrayList<Character> midExp){
        ArrayList<Character> list=new ArrayList();
        Stack<Character> stack=new Stack();
        char ch;
        for(int i=0;i<midExp.size();i++){
            ch=midExp.get(i);
            if(ch>='0'&&ch<='9'){
                list.add(ch);
            }else{
                if(ch=='('){
                   stack.push(ch);
                }else if(ch==')'){
                    if(stack.isEmpty())throw new RuntimeException("位置"+i+"处的)缺少对应的(");
                    while(stack.peek()!='('){
                        list.add(stack.pop());
                    }
                    if(stack.isEmpty()||stack.pop()!=')')throw new RuntimeException("位置"+i+"处的)缺少对应的(");
                }else {
                    while(!stack.isEmpty()&&getOperationLevel(ch)>getOperationLevel(stack.peek())){
                        list.add(stack.pop());
                    }
                    stack.push(ch);
                }
            }
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 得到操作符的等级
     * @param ch
     * @return
     */
    public static int getOperationLevel(char ch){
        if(ch=='%'||ch=='*')return 1;
        else if(ch=='+'||ch=='-')return 0;
        throw new IllegalArgumentException("操作符必须是%,*,+,-");
    }


    public static ArrayList<String> midExpression(String exp){
        ArrayList<String> list=new ArrayList();
        char ch;
        for(int i=0;i<exp.length();i++){
            ch=exp.charAt(i);
            if (!isValid(ch)) throw new IllegalArgumentException("非法字符="+ch);
            if(ch>='0'&&ch<='9'){
                StringBuffer number=new StringBuffer(ch+"");
                //找到连续的数字
                while (i<exp.length()-1 && (ch=exp.charAt(i+1))>='0' && ch<='9') {
                    number.append(ch+"");
                    i++;
                }
                list.add(number.toString());
            }else if(ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'){
                list.add(ch+"");
            }
        }
        return list;
    }

    public static boolean isValid(char ch){
        return ch=='+'||ch=='-'||ch=='*'||ch=='/'||ch=='('||ch==')'||
                (ch>='0' && ch<='9');
    }

    public static void main(String[] args) {
        String exp="1+3*5/6-3";
        cal(exp);
        System.out.println(1+3*5/6-3);
    }

}
