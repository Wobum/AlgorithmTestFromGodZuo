package SecondClass;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
/**
 * @Auther: Wobum
 * @Date: 2018/11/13 09:47
 * @Description: 用队列结构实现栈结构
 */
    private Queue<Integer> queue;
    private Queue<Integer> help;

    public QueueToStack(){
        this.queue = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    public void push(int pushInt){
        this.queue.add(pushInt);
    }

    public int pop(){
        if(this.queue.isEmpty()){
            throw new RuntimeException("The queue is empty!");
        }
        while (this.queue.size() > 1){
            this.help.add(this.queue.poll());
        }
        int res = this.queue.poll();
        this.swap();
        return res;
    }

    public int peek(){
        if (this.queue.isEmpty()){
            throw new RuntimeException("The queue is empyt!");
        }
        while (this.queue.size() > 1){
            this.help.add(this.queue.poll());
        }
        int res = this.queue.poll();
        help.add(res);
        this.swap();
        return res;
    }

    private void swap(){
        Queue<Integer> temp = this.queue;
        this.queue = this.help;
        this.help = temp;
    }

    public static void main(String[] args) {
        QueueToStack qs = new QueueToStack();
        qs.push(1);
        qs.push(2);
        qs.push(3);
        qs.push(4);
        qs.push(5);
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());
        System.out.println(qs.pop());

    }
}
