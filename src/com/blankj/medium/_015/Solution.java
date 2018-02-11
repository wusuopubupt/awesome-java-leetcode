package com.blankj.medium._015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/14
 *     desc  :
 *     题意是让你从数组中找出所有三个和为 0 的元素构成的非重复序列，这样的话我们可以把数组先做下排序，
 *     然后遍历这个排序数组，用两个指针分别指向当前元素的下一个和数组尾部，判断三者的和与 0 的大小来移动两个指针，
 *     其中细节操作就是优化和去重。
 * </pre>
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return list;
        // 先排序
        Arrays.sort(nums);
        int max = nums[len - 1];
        // 最大值小于0, 那么不存在sum == 0 的解
        if (max < 0) return list;
        for (int i = 0; i < len - 2; ) {
            // 最小值小于0, 那么不存在sum == 0 的解
            if (nums[i] > 0) break;
            if (nums[i] + 2 * max < 0) {
                while (nums[i] == nums[++i] && i < len - 2) ;
                continue;
            }
            // 对于任意一个nums[i]，在数组中的其他数中解2sum问题，目标为target-sums[i]
            int left = i + 1, right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重
                    while (nums[left] == nums[++left] && left < right) ;
                    while (nums[right] == nums[--right] && left < right) ;
                } else if (sum < 0) ++left;
                else --right;
            }
            while (nums[i] == nums[++i] && i < len - 2) ;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}