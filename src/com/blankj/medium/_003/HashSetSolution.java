package com.blankj.medium._003;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dash wang on 2/11/18.
 * <p>
 * HashSet + 双指针 问题
 */
public class HashSetSolution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int head = 0, tail = 0;
        for (head = 0; head < len; head++) {
            // 出现重复, 移动尾指针,直到不重复为止
            while (set.contains(s.charAt(head))) {
                set.remove(s.charAt(tail));
                tail++;
            }
            set.add(s.charAt(head));
            int tempLen = head - tail + 1;
            if (tempLen > max) {
                max = tempLen;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        HashSetSolution solution = new HashSetSolution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("Abcabcbb"));
    }
}
