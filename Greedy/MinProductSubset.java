package Greedy;

import java.util.Scanner;

public class MinProductSubset {
  static int minProductSubset(int a[], int n) {
    if (n == 1)
      return a[0];
    int negmax = Integer.MIN_VALUE;
    int posmin = Integer.MAX_VALUE;
    int count_neg = 0, count_zero = 0;
    int product = 1;

    for (int i = 0; i < n; i++) {
      // if number is zero, count it but don’t multiply
      if (a[i] == 0) {
        count_zero++;
        continue;
      }

      // count the negative numbers and find the max negative number
      if (a[i] < 0) {
        count_neg++;
        negmax = Math.max(negmax, a[i]);
      }

      // find the minimum positive number
      if (a[i] > 0 && a[i] < posmin)
        posmin = a[i];

      product *= a[i];
    }

    // if there are all zeroes or zero is present but no negative number is present
    if (count_zero == n || (count_neg == 0 && count_zero > 0))
      return 0;
    
    // If there are all positive
    if (count_neg == 0)
      return posmin;
    
    // If there are even number except zero of negative numbers
    if (count_neg % 2 == 0 && count_neg != 0) {
      //Otherwise, result is product of all non-zeros divided by maximum valued negative.
      product = product / negmax;
    }
    return product;
  }
  
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String[] arr=sc.next().split(",");

    int n=arr.length;
    int a[] = new int[arr.length];

    for(int i=0;i<arr.length;i++)
      a[i]=Integer.parseInt(arr[i]);

    System.out.println(minProductSubset(a, n));
  }
}
