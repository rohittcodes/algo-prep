/*
You are given an integer array nums of length n and an integer target. 
Your task is to find three integers in nums such that their sum is closest to the given target.

Return the sum of these three integers.

You may assume that each input would have exactly one solution.

Input Format:
-------------
Line-1: An integer n, the size of the array.
Line-2: n space-separated integers representing the elements of the array nums.
Line-3: A single integer target.

Output Format:
--------------
Line-1: Print a single integer, representing the sum of three integers closest to the target.

Sample Input-1:
---------------
4
-1 2 1 -4
1

Sample Output-1:
----------------
2

Sample Input-2:
---------------
3
0 0 0
1

Sample Output-2:
----------------
0

*/

package TwoPointers;

import  java.util.*;

public class ThreeSumClosest {
    public static int closestSum(int arr[], int target){
        // use `.abs()` to get the closest sum
        Arrays.sort(arr);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i]+" ");
        // }

        // loop through the array, and find sum of 3 elements and check if it is closest to target
        // if it is closest to target, then update the sum
        int closestSum = arr[0] + arr[1] + arr[2];
        for(int i=0; i<arr.length-2; i++){
            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(Math.abs(target - sum) < Math.abs(target - closestSum)){
                    closestSum = sum;
                }
                if(sum > target){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return closestSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i <n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(closestSum(arr, target));
        // closestSum(arr, target);
    }
}