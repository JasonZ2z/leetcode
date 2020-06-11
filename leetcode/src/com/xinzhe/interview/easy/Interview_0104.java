package com.xinzhe.interview.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Xin
 * @create 2020/6/10
 * Title : 01.04. Palindrome Permutation LCCI
 * Description : Given a string, write a function to check if it is a permutation of a palin­ drome. A palindrome is a word or phrase that is the same forwards and backwards.
 *              A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * link : https://leetcode-cn.com/problems/palindrome-permutation-lcci
 */
public class Interview_0104 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map.values().stream().filter(a -> (a & 1) == 1).count() <= 1;
    }
}
