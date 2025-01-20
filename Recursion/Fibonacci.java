/*
 * Fibonacci series is a series of numbers in which each number is the sum of the two preceding ones, usually starting with 0 and 1.
 * The task here is to find the nth number in the Fibonacci series.
 */

package Recursion;

import java.util.*;

public class Fibonacci {
  public static int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return fib(n - 1) + fib(n - 2);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the value of n: ");
    int n = sc.nextInt();
    System.out.println(fib(n));
    sc.close();
  }
}