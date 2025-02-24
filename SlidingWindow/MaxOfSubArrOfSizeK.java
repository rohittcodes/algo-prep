/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
- Example 1:
    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation:
    Window position Max
    ------------------------ -----
    [1 3 -1] -3 5 3 6 7 3
    1 [3 -1 -3] 5 3 6 7 3
    1 3 [-1 -3 5] 3 6 7 5
    1 3 -1 [-3 5 3] 6 7 5
    1 3 -1 -3 [5 3 6] 7 6
    1 3 -1 -3 5 [3 6 7] 7
- Example 2:
    Input: nums = [1], k = 1
    Output=[1]

- Example-3
    Input: a[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, k = 3
    Output: 3 3 4 5 5 5 6
    Explanation:
    Maximum of subarray {1, 2, 3} is 3
    Maximum of subarray {2, 3, 1} is 3
    Maximum of subarray {3, 1, 4} is 4
    Maximum of subarray {1, 4, 5} is 5
    Maximum of subarray {4, 5, 2} is 5
    Maximum of subarray {5, 2, 3} is 5
    Maximum of subarray {2, 3, 6} is 6

Time Complexity: O(n)
*/

