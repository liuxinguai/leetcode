package com.github.leetcode;

import java.nio.charset.StandardCharsets;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        byte[] line = new String("\n").getBytes(StandardCharsets.UTF_8);
        byte[] line2 = new String("\n").getBytes();
        byte[] line3 = new String("\r\n").getBytes(StandardCharsets.UTF_8);
        byte[] line4 = new String("\r\n").getBytes();
        System.out.printf("\n");
        System.out.println("hello");
    }
}
