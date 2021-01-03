package dynamic;

public class dy121 {
    public int maxProfit(int[] prices){
        int minprice = prices[0];
        int maxprofit = 0;

        for (int i = 1; i < prices.length; i++){
            minprice = Math.min(minprice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }

        return maxprofit;
    }
}
