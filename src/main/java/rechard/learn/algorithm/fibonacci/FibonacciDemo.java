package rechard.learn.algorithm.fibonacci;

import java.util.Stack;

public class FibonacciDemo {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		for (int i=0;i<40;i++){
			System.out.println("1--"+i+" = "+fibonacci1(i));
		}
		System.out.println(System.currentTimeMillis()-begin);
		
		begin = System.currentTimeMillis();
		for (int i=0;i<40;i++){
			System.out.println("2--"+i+" = "+fibonacci2(i));
		}
		System.out.println(System.currentTimeMillis()-begin);
		
		begin = System.currentTimeMillis();
		for (int i=0;i<40;i++){
			System.out.println("3--"+i+" = "+fibonacci_stack(i,new Stack<Integer>()));
		}
		System.out.println(System.currentTimeMillis()-begin);
	}
	
	
	public static int fibonacci_stack(int n,Stack<Integer> stack){
		if(n<=0){
			return 0;
		}else if(n==1){
			return 1;
		}
		stack.push(0);
		stack.push(1);
		for(int i=1;i<n;i++){
			int before =  stack.pop();
			int beforebefore = stack.pop();
			stack.push(before);
			stack.push(beforebefore+before);
		}
		return stack.pop();
	}
	
	
	public static int fibonacci1(int n){
		if(n<=0)
			return 0;
		else if(n==1)
			return 1;
		else
			return fibonacci1(n-1)+fibonacci1(n-2);
	}

	public static int fibonacci2(int n){
		if(n<=0)
			return 0;
		else if(n==1)
			return 1;
		else{
			int result = 0 ;
			int a = 0;
			int b = 1;
			for(int i=1;i<n;i++){
				result = a+b;
				a = b;
				b =result;
			}
			return result;
		}
	}
	
}
