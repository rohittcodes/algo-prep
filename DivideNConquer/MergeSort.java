package DivideNConquer;

import java.util.*;

public class MergeSort {
  public static void mergeSort(int[] arr, int low, int high) {
    if (low < high) {
      int mid = (low + high) / 2;
      // recursively sort the elements before and after the middle element
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      // merge the sorted arrays
      merge(arr, low, mid, high);
    }
  }

  public static void merge(int[] arr, int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;
    int[] left = new int[n1];
    int[] right = new int[n2];
    // copy the elements to the left and right arrays
    for (int i = 0; i < n1; i++) {
      left[i] = arr[low + i];
    }
    for (int i = 0; i < n2; i++) {
      right[i] = arr[mid + 1 + i];
    }
    int i = 0, j = 0, k = low;
    // merge the left and right arrays
    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
        arr[k] = left[i];
        i++;
      } else {
        arr[k] = right[j];
        j++;
      }
      k++;
    }
    // copy the remaining elements of left and right arrays
    while (i < n1) {
      arr[k] = left[i];
      i++;
      k++;
    }
    while (j < n2) {
      arr[k] = right[j];
      j++;
      k++;
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of elements in the array: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.println("Enter the elements of the array: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    mergeSort(arr, 0, n - 1);
    System.out.println("Sorted array: " + Arrays.toString(arr));
    sc.close();
  } 
}
