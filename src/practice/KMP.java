package practice;

public class KMP {
    public static void main(String args[]){
        String str1 = "GTGTGAGCTGGTGTGTGCFAA";
        String str2 = "GTGTGCF";
//        practice.KMP(str1, str2);
        KMP kmp = new KMP();
        int next[] = kmp.getNext(str2);
//        int next[] = getNext(str2);

        int match = 0;  //匹配上的数量
        int move = 0;  //从next数组中获取移动步数
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) == str2.charAt(i)){
                match++;
                continue;
            }
            move = next[match];
        }

        System.out.println("he");
    }

    public int[] getNext(String str){ //生成next数组
        int len = str.length();  // 模式串长度
        int next[] = new int[len];  // 定义next数组
        next[0] = 0;
        if (len >= 1){
            next[1] = 0;
        }
        int i = 2;
        int j = 0;
        int flag = 0;  // 0表示还没有相等过，1表示已经相等过
        int j0 = 1; //表示j还没有等于过0
        while(i < len){
            if (str.charAt(j) == str.charAt(i - 1)){
                next[i] = next[i-1] + 1;
                i++;
                j++;
                flag = 1;
            }else if(flag == 0){
                next[i] = 0;
                i++;
            }else if (flag == 1){
                if (j0 == 0){
                    next[i] = 0;
                    i++;
                }
                j = next[j];
                if(j == 0){
                    j0 = 0;
                }
            }
        }
        return next;
    }
    private static int[] getNexts(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i=2; i<pattern.length(); i++) {
            while (j != 0 && pattern.charAt(j) != pattern.charAt(i-1)) {
                //从next[i+1]的求解回溯到 next[j]
                j = next[j];
            }
            if (pattern.charAt(j) == pattern.charAt(i-1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
