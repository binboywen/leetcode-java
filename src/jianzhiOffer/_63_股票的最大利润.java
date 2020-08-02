package jianzhiOffer;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储再数组中，请问买卖该股票
 * 一次可能获得的最大利润是多少？例如，一只股票再某些时间节点的价格
 * 为{9,11,8,5,7,12,16,14}。如果我们能在价格为5的时候买入并在价格为
 * 16时卖出，则能收获最大利润11.
 * 扫描第i个数时，记录前面的i-1个数中的最小值，就能算得在当前价位卖
 * 出时可能得到的最大利润。
 */
public class _63_股票的最大利润 {
    public static int maxProfit(int [] prices){
        if(prices == null || prices.length == 0)
            return 0;
        int soFarMin = prices[0];
        
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            soFarMin = Math.min(soFarMin,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }
}
