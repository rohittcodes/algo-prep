package BinarySearch;

import java.util.*;

public class MedianTwoSorted {
  public static int findMedianSortedArrays(int[] arr1, int[] arr2){
    if (arr1.length > arr2.length) {
      return findMedianSortedArrays(arr2, arr1);
    }
    int x = arr1.length;
    int y = arr2.length;
    int low = 0;
    int high = x;
    while (low <= high) {
      int partitionX = (low + high) / 2;
      int partitionY = (x + y + 1) / 2 - partitionX;
      int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : arr1[partitionX - 1];
      int minRightX = (partitionX == x) ? Integer.MAX_VALUE : arr1[partitionX];
      int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : arr2[partitionY - 1];
      int minRightY = (partitionY == y) ? Integer.MAX_VALUE : arr2[partitionY];
      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        if ((x + y) % 2 == 0) {
          return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
        } else {
          return Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) {
        high = partitionX - 1;
      } else {
        low = partitionX + 1;
      }
    }
    throw new IllegalArgumentException();
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the size of the first array: ");
    int n = sc.nextInt();
    int[] arr1 = new int[n];
    System.out.println("Enter the elements of the first array: ");
    for (int i = 0; i < n; i++) {
      arr1[i] = sc.nextInt();
    }
    System.out.println("Enter the size of the second array: ");
    int m = sc.nextInt();
    int[] arr2 = new int[m];
    System.out.println("Enter the elements of the second array: ");
    for (int i = 0; i < m; i++) {
      arr2[i] = sc.nextInt();
    }
    System.out.println("The median of the two sorted arrays is: " + findMedianSortedArrays(arr1, arr2));
    sc.close();
  }
}
