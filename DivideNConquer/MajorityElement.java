/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than n/2 times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

package DivideNConquer;

import java.util.*;

public class MajorityElement {
  public static int majorityRec(int[] arr, int low, int high) {
    if (low == high) {
      return arr[low];
    }
    int mid = low + (high - low) / 2;
    int left = majorityRec(arr, low, mid);
    int right = majorityRec(arr, mid + 1, high);
    if (left == right) {
      return left;
    }
    int leftCount = 0;
    int rightCount = 0;
    // Count the number of left and right elements in the array
    for (int i = low; i <= high; i++) {
      if (arr[i] == left) {
        leftCount++;
      } else if (arr[i] == right) {
        rightCount++;
      }
    }
    return leftCount > rightCount ? left : right;
  }

  public static int majorityElement(int[] arr) {
    return majorityRec(arr, 0, arr.length - 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println("Majority Element: " + majorityElement(arr));
    sc.close();
  }
}
