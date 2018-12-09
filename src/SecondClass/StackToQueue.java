package SecondClass;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackToQueue {
/**
 * @Auther: 81421
 * @Date: 2018/11/13 09:29
 * @Description: 栈结构实现队列结构
 */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackToQueue(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public int pop(){
        if (this.stack2.empty() && this.stack1.empty()){
            throw new RuntimeException("Queue is empty!");
        }else if(this.stack2.empty()) {
            while (!this.stack1.empty()) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.pop();
    }

    public void push(int newNum){
        this.stack1.push(newNum);
    }

    public int peek(){
        if (this.stack2.empty() && this.stack1.empty()){
            throw new RuntimeException("Queue is empty!");
        }else if(this.stack2.empty()) {
            while (!this.stack1.empty()) {
                this.stack2.push(this.stack1.pop());
            }
        }
        return this.stack2.peek();
    }

    public static void main(String[] args) {
        StackToQueue sq = new StackToQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        sq.push(5);
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());
        System.out.println(sq.pop());





    }
}
