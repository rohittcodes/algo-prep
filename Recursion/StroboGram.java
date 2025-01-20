/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * e.g. 69, 88, 818, 11, 916
 */

package Recursion;

import java.util.*;

public class StroboGram {
  public static List<String> findStrobogrammatic(int n) {
    return helper(n, n);
  }

  public static List<String> helper(int n, int m) {
    if (n == 0) return new ArrayList<>(Arrays.asList(""));
    if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));

    List<String> list = helper(n - 2, m);
    List<String> res = new ArrayList<>();

    int count = 0;
    for (String s : list) {
      System.out.println(count++);
      if (n != m) res.add("0" + s + "0");
      res.add("1" + s + "1");
      res.add("6" + s + "9");
      res.add("8" + s + "8");
      res.add("9" + s + "6");
    }

    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number: ");
    int n = sc.nextInt();
    System.out.println(findStrobogrammatic(n));
    sc.close();
  }
}