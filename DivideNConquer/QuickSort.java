package DivideNConquer;

import java.util.*;

public class QuickSort {
  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      // get the pivot element
      int pivot = partition(arr, low, high);
      // recursively sort the elements before and after the pivot
      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
    System.out.println("Sorted array: " + Arrays.toString(arr));
  }

  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;
    // iterate through the array and swap elements less than pivot to the left
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    // swap the pivot element with the element at i + 1. This will place the pivot element at its correct position
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
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
    quickSort(arr, 0, n - 1);
    sc.close();
  } 
}
