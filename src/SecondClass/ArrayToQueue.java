package SecondClass;

public class ArrayToQueue {
/**
 * @Auther: 81421
 * @Date: 2018/11/12 16:36
 * @Description: 用数组实现队列（对尾进，对头出）
 */
    private Integer[] arr;
    private Integer s; //表示队列的开始位置，如果要求返回一个数据，则返回该位置的数据，s++，size--
    private Integer e; //表示队列的结束位置,如果进来一个数据，则添加到该位置，e++，size++
    private Integer size;

    public ArrayToQueue(Integer initsize){
        if (initsize < 0){
            throw new IllegalArgumentException("The initsize is less than 0");
        }
        arr = new Integer[initsize];
        size = 0;
        s = 0;
        e = 0;
    }

    // 返回队首元素，但不删除该元素。
    public Integer peek(){
        if (size == 0){
            return  null;
        }
        return arr[s];
    }

    // 弹出队首元素
    public Integer poll(){
        if (size == 0){
            throw new ArrayIndexOutOfBoundsException("The queue is empty!");
        }
        size--;
        int temp = s;
        s = s == arr.length -1 ? 0 : s + 1;
        return arr[temp];
    }

    //在队尾压入元素
    public void push(Integer obj){
        if (size == arr.length){
            throw new ArrayIndexOutOfBoundsException("The queue is Full!");
        }
        size++;
        arr[e] = obj;
        e = e == arr.length - 1 ? 0 : e +1;
    }

    public static void main(String[] args) {

    }
}
