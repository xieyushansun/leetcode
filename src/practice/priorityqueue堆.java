package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

class priorityqueue堆 {
    public static void main(String[] args){
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;  // 从大到小排序
            }
        });
        pq.add(2);
        pq.add(2);
        pq.add(5);
        pq.add(6);
        pq.add(3);
        if (pq.contains(2)){
            System.out.println("yes");
        }
        pq.offer(4);
        pq.remove(2);
        pq.remove(5);
        pq.remove();
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println("end");
    }
}