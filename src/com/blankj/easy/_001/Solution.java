package com.blankj.easy._001;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/21
 *     desc  :
 * </pre>
 */
public class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; ++i) {
//            for (int j = i + 1; j < nums.length; ++j) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    // Input array is sorted
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
    public int[] twoSumOrdered(int[] num, int target) {
        int[] indice = new int[2];
        if(num == null || num.length < 2) {
            return indice; 
        }
        int left = 0;
        int right = num.length - 1;
        while(left < right) {
            int sum = num[left] + num[right];
            if(sum == target) {
                indice[0] = left;
                indice[1] = right;
                return indice;
            } else if(sum < target) {
                left++;
            } else {
                right--; 
            }

        }
        return indice;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
