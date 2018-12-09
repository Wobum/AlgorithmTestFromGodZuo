package SecondClass;

public class ArrayToStack {
/**
 * @Auther: 81421
 * @Date: 2018/11/12 15:41
 * @Description: 用数组结构实现栈结构
 */
    private Integer[] arr;
    private Integer size;

    public ArrayToStack(int initsize){
        if(initsize < 0){
            throw new IllegalArgumentException("The initsize is less than 0 ");
        }
        arr = new Integer[initsize];
        size = 0;
    }

    // 返回栈中的元素，但是不删除该元素
    public Integer peek(){
        if(size == 0){
            return  null;
        }
        return arr[size - 1];
    }

    //返回栈中的元素，并删除该元素
    public Integer pop(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("The Stack is empty!");
        }
        return arr[--size];
    }

    //
    public void push(int obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("The Stack is full!");
        }
        arr[size++] = obj;
    }

    public static void main(String[] args) {
        ArrayToStack s = new ArrayToStack(5);
        s.push(1);
        s.push(2);
        System.out.println(s.peek());
        s.push(5);
        s.push(10);
        System.out.println(s.peek());
        s.push(15);
        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());

    }
}
