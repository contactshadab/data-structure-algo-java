package shadab.programs.array;

public class ImplementTwoStacksInOneArray {
	
	public static void main(String[] args) {
		Stack myStack = new Stack(4);
		myStack.push1(1);
		myStack.push1(2);
		myStack.push1(3);
		myStack.push2(4);
		myStack.pop1();
		myStack.push2(5);

	}

}

class Stack {
	private int[] stack;
	private int top1;
	private int top2;
	Stack(int size) {
		this.stack = new int[size];
		this.top1 = -1; //Invalid position
		this.top2 = size; //Invalid position
	}
	
	public void push1(int data){
		if(this.top1 + 1 >= this.top2)
			throw new StackOverflowError("Stack is full");
		
		this.stack[++this.top1] = data;
	}
	
	public void push2(int data){
		if(this.top2 - 1 <= this.top1)
			throw new StackOverflowError("Stack is full");
		
		this.stack[--this.top2] = data;
	}
	
	public int pop1(){
		if(this.top1 == -1)
			throw new StackOverflowError("Stack is already empty");
		
		return stack[top1--];
	}
	
	public int pop2(){
		if(this.top2 == this.stack.length)
			throw new StackOverflowError("Stack is already empty");
		
		return stack[top2++];
	}
}
