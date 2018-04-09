/**
 * 
 */

package com.prisbox.one;


/**
 * @author LO
 *
 */
public class HasAlternatingBits693 {

    public static boolean hasAlternatingBits(int n) {
        if(n < 3){
            return true;
        }
        int t = n & 1;
        n >>= 1;
        while(n > 0){
            if((t ^ (n & 1)) == 0){
                return false;
            };
            t = n & 1;
            n >>= 1;
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        hasAlternatingBits(5);
    }

}
