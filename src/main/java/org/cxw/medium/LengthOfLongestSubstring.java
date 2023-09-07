package org.cxw.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 司诚
 * @description 无重复字符最长子串
 * @date 2023/9/7
 */
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
//        lengthOfLongestSubstring.lengthOfLongestSubstring(" ");
    }

//    public int lengthOfLongestSubstring(String s) {
//        char[] chars = s.toCharArray();
//        Set<Character> set = new HashSet<>();
//        int maxLength = 0;
//        for (int i = 0; i < s.length() && chars.length >0 ; i++) {
//            char c = chars[i];
//            set.add(c);
//            for (int j = i+1 ; j < s.length(); j++) {
//                if (set.contains(chars[j])) {
//                    break;
//                }
//                set.add(chars[j]);
//            }
//            maxLength = Math.max(maxLength, set.size());
//            set.clear();
//        }
//
//
//        return maxLength;
//    }

    public int lengthOfLongestSubstring(String s) {
//        Set<Character> occ = new HashSet<>();
//        int maxLength = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (i != 0) {
//                occ.remove(s.charAt(i -1));
//            }
//
//            for (int j = i-1; j < s.length() ; j++) {
//                if (occ.contains(s.charAt(j+1))) {
//                    break;
//                }
//                occ.add(s.charAt(j+1));
//
//            }
//
//
//
//            maxLength = Math.max(maxLength, occ.size());
//
//        }
//
//
//        return maxLength;
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        //先移动右指针，如果重复停下来，然后再移动左指针+右指针，重复就就停下来动左指针，每次遇到重复做一个max记录
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
