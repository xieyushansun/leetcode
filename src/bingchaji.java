import java.util.Scanner;

public class bingchaji {
    static int pre[] = new int[1010];
    public static void main(String[] args){
        int num = 20;  // 4 x 5
        int total = num;
        int[][] roads = {{2, 3}, {1, 5}, {5, 9}, {4, 8}, {7, 8}, {9, 10},
                {10, 11}, {11, 12}, {10, 14}, {12, 16}, {14, 18},
                {17, 18}, {19, 15}, {19, 20}, {9, 13}, {13, 17}};

        int road = 16;
//        Scanner input=new Scanner(System.in);//创建一个键盘扫描类对象
//
//        int m = input.nextInt();
//        int n = input.nextInt();
//        int total = m * n;
//        int num = m * n;
//        int road = input.nextInt();
//        int[][] roads = new int[road][2];
//
//        for (int i = 0; i < road; i++){
//            roads[i][0] = input.nextInt();
//            roads[i][1] = input.nextInt();
//        }

        for(int i = 1; i <= num; ++i) { //每条路都是掌门
            pre[i] = i;
        }
        for (int i = 0; i < road; i++){
            int start = roads[i][0];
            int end = roads[i][1];

            int root1 = unionsearch(start);
            int root2 = unionsearch(end);
            if (root1 != root2){
                pre[root1] = root2;
                total--;
            }
        }
        System.out.println(total);
    }


    public static int unionsearch(int root) //查找根结点
    {
        int son, tmp;
        son = root;
        while(root != pre[root]) //我的上级不是掌门
            root = pre[root];
        //路径压缩
        while(son != root) //我就找他的上级，直到掌门出现
        {
            tmp = pre[son];
            pre[son] = root;
            son = tmp;
        }
        return root; //掌门驾到~~
    }
}
