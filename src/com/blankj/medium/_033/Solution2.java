package com.blankj.medium._033;

/**
 * Created by dash wang on 2/11/18.
 */
public class Solution2 {

    private int findDivisionIndex(int[] nums, int len) {
        int left = 0, right = 1;
        while (right < len && nums[left] < nums[right]) {
            left++;
            right++;
        }
        return left;
    }

    private int binarySearchRecursive(int[] nums, int low, int high, int target) {
        int foundIndex = -1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearchRecursive(nums, low, mid - 1, target);
            } else {
                return binarySearchRecursive(nums, mid + 1, high, target);
            }
        }
        return foundIndex;
    }

    private int binarySearchIteration(int[]  nums, int low, int high, int target) {
        int foundIndex = -1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return foundIndex;
    }

    public int search(int[] nums, int target) {
        int index = -1;
        int len = nums.length;
        // Find division index
        int divisionIndex = findDivisionIndex(nums, len);
        // Decide which side to search
        if (nums[0] <= target && nums[divisionIndex] >= target) {
            index = binarySearchIteration(nums, 0, divisionIndex, target);
        } else if (nums[divisionIndex + 1] <= target && nums[len - 1] >= target) {
            index = binarySearchIteration(nums, divisionIndex + 1, len, target);
        }
        return index;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.search(new int[]{2, 1}, 1));
    }
}
