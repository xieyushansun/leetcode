package practice;

import java.util.ArrayList;
import java.util.List;

//package practice;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Stack;
//
///**
//22. 括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//示例：
//输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// */
//class TreeNode{
//    TreeNode left;
//    TreeNode right;
//    char val;
//    TreeNode(char v){
//        val = v;
//    }
//}
//public class 括号生成22 {
//    static int num = 0;
//    static List<String> result = new ArrayList<>();
//    public static void main(String[] args){
//        generateParenthesis(3);
//    }
//    public static List<String> generateParenthesis(int n) {
//        result = new ArrayList<>();
//        TreeNode head = new TreeNode('(');
//        construct(head, 1, n);
//        num = n-1;
//        List<Character> stack = new ArrayList<>();
//        if (n == 1){
//            result.add("()");
//            return result;
//        }
//        travel(head, stack);
//        return result;
//    }
//    public static void construct(TreeNode head, int layer, int n){
//        if (layer >= 2*n){
//            return;
//        }
//        head.left = new TreeNode('(');
//        head.right = new TreeNode(')');
//        construct(head.left, layer + 1, n);
//        construct(head.right, layer + 1, n);
//    }
//    public static void travel(TreeNode node, List<Character> stack){
//        if (stack.size() == num*2 && stack.indexOf(stack.size() - 1) != '(' && judge(stack) == 0){
//            StringBuilder re = new StringBuilder();
//            List<Character> ll = new ArrayList<>(stack);
//            ll.add(')');
//            ll.add(0, '(');
//            Iterator<Character> iterator = ll.iterator();
//            while (iterator.hasNext()){
//                re.append(iterator.next());
//            }
//
//            result.add(re.toString());
//            return ;
//        }
//        if (node != null){
//            if (node.val == '('){
//                stack.add('(');
//            }else if (judge(stack) == -1){
//                return ;
//            }else {
//                stack.add(')');
//            }
//            if (node.left == null && node.right == null){
//                List<Character> ll1 = new ArrayList<>(stack);
//                travel(node.left, ll1);
//            }else {
//                List<Character> ll1 = new ArrayList<>(stack);
//                travel(node.left, ll1);
//                List<Character> ll2 = new ArrayList<>(stack);
//                travel(node.right, ll2);
//            }
//        }
//    }
//    public static int judge(List<Character> stack){
//        List<Character> list =  new ArrayList<>(stack);
//        Stack<Character> s = new Stack<>();
//        Iterator<Character> iterator = list.iterator();
//        int left = 0;
//        int right = 0;
//        while (iterator.hasNext()){
//            char ch = iterator.next();
//            if (ch == '('){
//                left++;
//                s.push(ch);
//            }else if (!s.isEmpty()){
//                right++;
//                s.pop();
//            }else {
//                return -1;
//            }
//            if (left > num || right > num){
//                return -1;
//            }
//        }
//
//        if (s.isEmpty()){
//            return 0;
//        }else if (s.peek() == '('){
//            return 1;
//        }else {
//            return -1;
//        }
//
//    }
//}
public class 括号生成22 {
    public static void main(String[] args){
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
