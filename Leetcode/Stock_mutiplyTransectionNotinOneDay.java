/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stock_mutiplytransectionnotinoneday;

/**
 *
 * @author Xi Yu
 */
public class Stock_mutiplyTransectionNotinOneDay {
    /**Assume you daily prices of a stock 
3 7 4 10 11 8 5 4 8 yadda yadda 
You can only buy 1 share or sell 1 share a day, but you can only sell if you own the stock. You can't hold more than 1 share. write me an algo that finds me the strategy that has the highest pay off.
Don't want the generate all possible strategies and compare.
     * @param args the command line arguments
     * 该问题总是要考虑当天的股票价格和后一天的股票价格，如果后一天大于当天的且手头没有任何操作，买进，如果明天的小于今天的且手头有股票的，卖出
     */
    public int sellstock(int[] a){
        int profit=0;
        int buy = -1;
        int i;
        for(i = 0; i < a.length-1; i++ ) {
            
            if( buy == -1 && a[i] < a[i+1]) {
                buy = i;
                System.out.println( "Buy on day "+(i));
            } else if( buy != -1 && a[i] > a[i+1]) {
                profit += a[i]-a[buy];
                buy = -1;
                System.out.println("Sell on day "+(i));
            }
        }
        if( buy != -1 ) {
            profit += a[a.length-1]-a[buy];
            System.out.println("Sell on day"+i );
        }
        return profit;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stock_mutiplyTransectionNotinOneDay test = new Stock_mutiplyTransectionNotinOneDay();
        int[] a = {2,1,3,6,8,2,4,2,2};
        int profit = test.sellstock(a);
        System.out.println(profit);
    }
    
}
