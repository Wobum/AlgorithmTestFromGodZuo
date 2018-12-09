package SecondClass;

import java.util.Stack;

public class GetMinStack {
/**
 * @Auther: 81421
 * @Date: 2018/11/13 08:45
 * @Description: 实现一个特殊的 stack，在实现栈的基本功能上，在实现返回栈中最小元素的操作。
 *               要求： pop，push，getMin 操作时间复杂度都是 O(1)
 */
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
}

    public int pop(){
        if (this.stackData.empty()){
            throw new RuntimeException("The stack is empty!");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public void push(int newNum){
        if (this.stackData.empty()){
            this.stackMin.push(newNum);
        }else if (newNum < this.getMin()){
            this.stackMin.push(newNum);
        }else {
            int newMin = this.stackMin.peek();
            this.stackMin.push(newMin);
        }
        stackData.push(newNum);
    }

    public int getMin(){
        if (this.stackData.empty()){
            throw new RuntimeException("The stack is empty!");
        }
        return this.stackMin.peek();
    }


    public static void main(String[] args) {
        GetMinStack stack1 = new GetMinStack();
        stack1.push(3);
        stack1.push(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(4);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        stack1.pop();
        stack1.pop();
        System.out.println(stack1.getMin());
    }
}
