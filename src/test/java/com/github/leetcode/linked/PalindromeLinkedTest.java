package com.github.leetcode.linked;

import org.junit.Test;

public class PalindromeLinkedTest {

    @Test
    public void testBase() {
        PalindromeLinked<Integer> palindromeLinked = new PalindromeLinked<>(1);
        palindromeLinked.add(2).add(3).add(4).add(5).add(6);
        palindromeLinked.println();

    }

    @Test
    public void testIsPalindrome2() {
        PalindromeLinked<Integer> palindromeLinked = new PalindromeLinked<>(1);
        palindromeLinked.add(2).add(3).add(4).add(5).add(6);
        palindromeLinked.add(6).add(5).add(4).add(2).add(2).add(1);
        System.out.println(palindromeLinked.isPalindrome2());
    }

    @Test
    public void testIsPalindrome() {
        PalindromeLinked<Integer> palindromeLinked = new PalindromeLinked<>(1);
        palindromeLinked.add(2).add(2).add(2).add(1);
        System.out.println(palindromeLinked.isPalindrome());
    }
}
