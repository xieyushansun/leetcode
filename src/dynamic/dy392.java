package dynamic;

public class dy392 {
    public static void main(String[] args){
        String s = "abc";
        String t = "ahbgdc";
        isSubsequence(s, t);
    }
    public static boolean isSubsequence(String s, String t) {
        int last = 0;
        for (int i = 0; i < s.length(); i++){
            if (last < t.length()){
                String sub = t.substring(last);
                int index = sub.indexOf(s.charAt(i));
                if (index != -1){
                    last = last + index + 1;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
