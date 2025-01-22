package Greedy;

import java.util.*;

class BuyAndSellStock {
  public int maxProfit(int prices[]) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice)
        minprice = prices[i];
      else if (prices[i] - minprice > maxprofit)
        maxprofit = prices[i] - minprice;
    }

    return maxprofit;
  }

  public static void main(String args[]) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int ar[]=new int[n];
    for(int i=0;i<n;i++)
      ar[i]=sc.nextInt();
    System.out.println(new BuyAndSellStock().maxProfit(ar));
  }
}