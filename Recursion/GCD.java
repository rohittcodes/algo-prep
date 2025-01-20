/*
 * Given two numbers, find their GCD using recursion. GCD of two numbers is the largest number that divides both of them.
 */

package Recursion;

import java.util.Scanner;

public class GCD {
  public static int gcd(int a, int b) {
    if(a==b){
      return a;
    } else if(a==0){
      return b;
    } else if(b==0){
      return a;
    } else if(a>b){
      return gcd(a-b, b);
    } else {
      return gcd(a, b-a);
    }
  }

  // euclidean algorithm
  public static int gcdOptimized(int a, int b) {
    // if b is 0, then a is the gcd
    if(b==0){
      return a;
    } else {
      // otherwise, call the function recursively with b and a%b
      return gcdOptimized(b, a%b);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter two numbers: ");
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b));
    sc.close();
  }
}
