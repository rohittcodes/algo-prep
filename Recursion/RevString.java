/*
 * Reverse a string using recursion.
 * For example, if the input is "Hello", the output should be "olleH".
 */

package Recursion;

import java.util.*;

public class RevString {
  public static String reverse(String str){
    if(str.length() == 0){
      return "";
    }
    return reverse(str.substring(1)) + str.charAt(0);
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the string: ");
    String str = sc.nextLine();
    System.out.println("Reversed string: " + reverse(str));
    sc.close();
  }
}
