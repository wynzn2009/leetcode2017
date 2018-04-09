/**
 * 
 */

package com.prisbox.one;

import java.util.LinkedList;

/**
 * @author LO
 *
 */
public class LongestValidParentheses32 {

    public static int longestValidParentheses(String s) {
        int index = 0;
        int temp = 0;
        int max = 0;
        LinkedList<Integer> l = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(c.equals('(')){
                l.push(i + 1);
            }else{
                if(l.isEmpty() || l.peek() < 0){
                    l.push(-i - 1);
                }else if(l.peek() > 0){
                    l.pop();
                }
            }
        }
        if(l.isEmpty()){
            return s.length();
        }else{
            index = s.length() + 1;
            while(!l.isEmpty()){
                temp = Math.abs(l.pop());
                max = Math.max(max, index - temp - 1);
                index = temp;
            }
            max = Math.max(max, index - 1);
        }
        return max;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String t = ")(";
        System.out.println(longestValidParentheses(t));
    }

}
