import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

class test {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(5);  // 向队尾插入5
        deque.offerFirst(3);  // 向队头插入3
        deque.offerLast(12);
        // 此时状态 3，5，12
        // 正向遍历队列
        Iterator<Integer> iterator1 = deque.iterator();
        while (iterator1.hasNext()){
            System.out.print(iterator1.next() + " ");
        }
        System.out.println("");
        // 反向遍历
        Iterator<Integer> iterator2 = deque.descendingIterator();
        while (iterator2.hasNext()){
            int a = iterator2.next();
            System.out.print(a + " ");
        }
    }
}