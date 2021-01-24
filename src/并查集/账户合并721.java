package 并查集;

import java.util.*;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2021/1/18 9:16
 */
public class 账户合并721 {
    public static void main(String[] args){
        String[][] accounts1 = {{"John", "johnsmith@mail.com", "john00@mail.com"},
                {"John", "johnnybravo@mail.com"},
                {"John", "johnsmith@mail.com", "john_newyork@mail.com"},
                {"Mary", "mary@mail.com"}};
        String[][] accounts = {
                {"David","David0@m.co","David4@m.co","David3@m.co"},
                {"David","David5@m.co","David5@m.co","David0@m.co"},
                {"David","David1@m.co","David4@m.co","David0@m.co"},
                {"David","David0@m.co","David1@m.co","David3@m.co"},
                {"David","David4@m.co","David1@m.co","David3@m.co"}};
        String[][] accounts3 = {
                {"David","David0@m.co","David1@m.co"},
                {"David","David3@m.co","David4@m.co"},
                {"David","David4@m.co","David5@m.co"},
                {"David","David2@m.co","David3@m.co"},
                {"David","David1@m.co","David2@m.co"}};
        List<List<String>> account = new ArrayList<>();
        for (int i = 0; i < accounts.length; i++){
            List<String> list = Arrays.asList(accounts[i]);
            account.add(list);
        }
        accountsMerge(account);
        System.out.println("test");
    }
    static int[] pre;
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int ll = accounts.size();
        pre = new int[ll];
        for (int i = 0; i < ll; i++){
            pre[i] = i;
        }
        // key:邮箱 value:第一次出现的值
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < ll; i++){
            List<String> list = accounts.get(i);
            for (int j = 1; j < list.size(); j++){
                int value = map.getOrDefault(list.get(j), -1);
                if (value != -1 && value != i){
                    int root1 = findRoot(value);
                    int root2 = findRoot(i);
                    pre[root1] = root2;
                }else {
                    map.put(list.get(j), i);
                }

            }
        }
        List<List<String>> result = new ArrayList<>();
        Map<Integer, Set<String>> map1 = new HashMap<>();
        for (int i = 0; i < ll; i++){
            int root = findRoot(i);
            Set<String> list = map1.getOrDefault(root, new HashSet<>());
            List<String> l = new ArrayList<>();
            l.add(accounts.get(root).get(0));
            l.addAll(accounts.get(i).subList(1, accounts.get(i).size()));
            list.addAll(l);
            map1.put(root, list);
        }
        Iterator<Set<String>> iterator = map1.values().iterator();
        while (iterator.hasNext()){
            List<String> list = new ArrayList<>(iterator.next());
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            result.add(list);
        }
        return result;
    }
    public static int findRoot(int n){
        int t = n;
        while (n != pre[n]){
            n = pre[n];
        }
        int root = n;
        n = t;
        while (n != root){
            int temp = pre[n];
            pre[n] = root;
            n = temp;
        }
        return root;
    }
}
