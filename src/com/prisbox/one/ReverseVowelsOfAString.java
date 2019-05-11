/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length-1;
        String str = "aeiouAEIOU";
        int count = 0;
        while(l<r){
        	if(str.contains(String.valueOf(c[l]))){
        		count++;
        	}else{
        		l++;
        	}
        	if(str.contains(String.valueOf(c[r]))){
        		count++;
        	}else{
        		r--;
        	}
        	if(count==2){
        		c[l] = (char) (c[l]^c[r]);
        		c[r] = (char) (c[l]^c[r]);
        		c[l] = (char) (c[l]^c[r]);
        		l++;
        		r--;
        	}
        	count = 0;
        }
        return String.valueOf(c);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseVowelsOfAString r= new ReverseVowelsOfAString();
		String leetcode = "leetcode";
		System.out.println(r.reverseVowels(leetcode));
	}

}
