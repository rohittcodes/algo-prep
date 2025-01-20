/*
 * A happy number is a number which eventually reaches 1 when replaced by the sum of the square of each digit.
 * For example, 19 is a happy number:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
*/

package Recursion;

import java.util.*;

public class HappyNum {
  public static boolean isHappy(int n){
    // hashset to store the numbers which are already visited
    Set<Integer> set = new HashSet<>();
    while(n != 1){
      // if the number is already visited, then it will never be happy
      if (set.contains(n)) return false;
      set.add(n);
      n = sumOfDigs(n);
    }
    return true;
  }

  public static boolean isHappyWithArbitraryNum(int n){
    if (n == 1) return true;
    // if n is 4, then it will never be happy (an arbitrary case to stop the recursion, you can choose any number (e.g. 16, 37, 58, 89, 145) which will never be happy)
    if (n == 4) return false;
    return isHappy(sumOfDigs(n));
  }

  public static int sumOfDigs(int n){
    int sum = 0;
    while(n > 0){
      int dig = n % 10;
      sum += dig * dig;
      n /= 10;
    }
    return sum;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int n = sc.nextInt();
    System.out.println(isHappy(n));
    sc.close();
  }
}