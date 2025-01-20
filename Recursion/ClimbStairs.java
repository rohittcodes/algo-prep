/*
 * You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * The task here is to find the number of distinct ways to climb to the top.
 */

package Recursion;

import java.util.Scanner;

public interface ClimbStairs {
  public static int climb(int n){
    if (n<=2) {
      return n;
    }
    return climb(n-1) + climb(n-2);
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value of n: ");
    int n = sc.nextInt();
    System.out.println(climb(n));
    sc.close();
  }
}
