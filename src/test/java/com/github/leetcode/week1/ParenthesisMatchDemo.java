package com.github.leetcode.week1;

import org.junit.Test;

public class ParenthesisMatchDemo {

    @Test
    public void test() {
        ParenthesisMatch match = new ParenthesisMatch();
        match.add(ParenthesisMatch.PARENTHESIS_LEFT);
        match.add(ParenthesisMatch.BRACES_LEFT);
        match.add(ParenthesisMatch.SQUARE_LEFT);
        match.add(ParenthesisMatch.SQUARE_RIGHT);
        match.add(ParenthesisMatch.BRACES_RIGHT);
        match.add(ParenthesisMatch.PARENTHESIS_RIGHT);
        if (match.isVail()) {
            System.out.println(match.string());
        }
        match.clear();
        match.add(ParenthesisMatch.PARENTHESIS_LEFT);
        match.add(ParenthesisMatch.BRACES_LEFT);
        match.add(ParenthesisMatch.SQUARE_LEFT);
        match.add(ParenthesisMatch.SQUARE_RIGHT);
        match.add(ParenthesisMatch.BRACES_RIGHT);
        match.add(ParenthesisMatch.PARENTHESIS_LEFT);
        System.out.println(match.isVail()+","+match.string());
    }

}
