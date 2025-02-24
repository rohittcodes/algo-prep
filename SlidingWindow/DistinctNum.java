/*
Given an integer array nums and an integer k, you are asked to construct the array ans of size n-k+1 where ans[i] is the number of distinct numbers in the subarray nums[i:i+k-1] = [nums[i], nums[i+1], ..., nums[i+k-1]]. Return the array ans.

- Example 1:
    Input: nums = [1,2,3,2,2,1,3], k = 3
    Output: [3,2,2,2,3]
    Explanation: The number of distinct elements in each subarray goes as follows:
    - nums[0:2] = [1,2,3] so ans[0] = 3
    - nums[1:3] = [2,3,2] so ans[1] = 2
    - nums[2:4] = [3,2,2] so ans[2] = 2
    - nums[3:5] = [2,2,1] so ans[3] = 2
    - nums[4:6] = [2,1,3] so ans[4] = 3

- Example 2:
    Input: nums = [1,1,1,1,2,3,4], k = 4
    Output: [1,2,3,4]
    Explanation: The number of distinct elements in each subarray goes as follows:
    - nums[0:3] = [1,1,1,1] so ans[0] = 1
    - nums[1:4] = [1,1,1,2] so ans[1] = 2
    - nums[2:5] = [1,1,2,3] so ans[2] = 3
    - nums[3:6] = [1,2,3,4] so ans[3] = 4

Constraints:
    • 1 <= k <= nums.length <= 105
    • 1 <= nums[i] <= 105
*/

package SlidingWindow;

import java.util.*;

public class DistinctNum {
    public static int count(int arr[], int n, int k){
        Map<Integer, Integer> temp = new HashMap<>();
        // implement
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(count(arr, n, k));
    }
}