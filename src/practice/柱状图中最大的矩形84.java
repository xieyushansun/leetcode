package practice;

import java.util.ArrayDeque;
import java.util.Deque;

class 柱状图中最大的矩形84 {
    public static void main(String[] args){
        int[] height = {2, 2};
        int area = largestRectangleArea(height);
        System.out.println(area);
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0){
            return 0;
        }
        if (heights.length == 1){
            return heights[0];
        }
        // 找到左右两侧均小于该柱子的坐标
        int[] maxAreaLTR = new int[heights.length];
        int[] maxAreaRTL = new int[heights.length];
        maxAreaLTR[0] = -1; // 第一个元素左边没有值，所以左边比它
        maxAreaRTL[heights.length - 1] = heights.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);  // 把第一个元素的坐标入队
        for (int i = 1; i < heights.length; i++){
            // 如果新来的元素大于栈顶元素，则新来元素左边就是栈顶元素坐标
            // 同时将该元素入栈
            if (deque.isEmpty()){
                maxAreaLTR[i] = -1;
                deque.push(heights[i]);
            }else {
                if (heights[i] > heights[deque.peek()]){
                    maxAreaLTR[i] = deque.peek();
                    deque.push(i);
                }else {
                    while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]){
                        deque.pop();
                    }
                    if (deque.isEmpty()){
                        maxAreaLTR[i] = -1;
                        deque.push(i);
                    }else {
                        maxAreaLTR[i] = deque.peek();
                        deque.push(i);
                    }
                }
            }
        }
        deque = new ArrayDeque<>();
        deque.push(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--){
            if (deque.isEmpty()){
                maxAreaRTL[i] = heights.length;
                deque.push(heights[i]);
            }else {
                if (heights[i] > heights[deque.peek()]){
                    maxAreaRTL[i] = deque.peek();
                    deque.push(i);
                }else {
                    while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]){
                        deque.pop();
                    }
                    if (deque.isEmpty()){
                        maxAreaRTL[i] = heights.length;
                        deque.push(i);
                    }else {
                        maxAreaRTL[i] = deque.peek();
                        deque.push(i);
                    }
                }
            }
        }
        int max = 0;
        // 计算面积
        for (int i = 0; i < heights.length; i++){
            max = Math.max(max, heights[i] * (maxAreaRTL[i] - maxAreaLTR[i] - 1));
        }
        return max;
    }
}