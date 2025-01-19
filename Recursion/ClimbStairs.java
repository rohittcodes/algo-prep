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
    int n = sc.nextInt();
    System.out.println(climb(n));
    sc.close();
  }
}
