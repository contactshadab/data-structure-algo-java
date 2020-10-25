package dataStructure.stacks;

import java.util.Stack;

public class GetMinNoFromStack_ConstantTime {
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(40);
		stack.push(20);
		System.out.println(stack.getMin());
		stack.push(10);
		stack.push(0);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());

	}

}

class MinStack {
	private Stack<Integer> stack = new Stack();
	private Stack<Integer> supportingStack = new Stack();
	
	public void push(int item){
		stack.push(item);
		
		//Peek if the supporting stack's top is lessor than pushed item
		if(supportingStack.isEmpty() || item < supportingStack.peek()){
			supportingStack.push(item);
		}
	}
	
	public int pop(){
		int item = stack.pop();
		if(item == supportingStack.peek()){
			supportingStack.pop();
		}
		return item;
	}
	
	public int getMin(){
		return supportingStack.peek();
	}
	
}
