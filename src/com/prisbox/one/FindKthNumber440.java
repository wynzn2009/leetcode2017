/**
 * 
 */

package com.prisbox.one;

/**
 * @author LO
 *
 */
public class FindKthNumber440 {

    public static int findKthNumber(int n, int k) {
        String nstr = String.valueOf(n);
        int[] num = new int[nstr.length()];
        int lg = 0;
        int sm = 0;
        int eq = 0;
        for(int i = 0; i < num.length; i++){
            num[i] = nstr.charAt(i) - '0';
            sm = sm * 10 + 1;
        }
        lg = (sm - 1) / 10;
        eq = n - sm + lg + lg + 1;
        if(k < sm * (nstr.charAt(0) - '0' - 1)){
            int start = (k - 1) / sm;
            int index = k % sm;
            return help(start, index, sm);
        }else if(k <= sm * (nstr.charAt(0) - '0' - 1) + eq){
            int start = sm * (nstr.charAt(0) - '0' - 1) + eq;
            int nn = n - 10*(nstr.charAt(0) - '0' - 1)
            
        }else{
            int start = (k - sm * (nstr.charAt(0) - '0' - 1) - eq - 1) / lg;
            int index = (k - sm * (nstr.charAt(0) - '0' - 1) - eq) % lg;
            return help(start, index, lg);
        }
    }

    private static int help(int start, int index, int length) {
        if (index <= 1) {
            return start;
        }
        int div = (length - 1) / 10;
        StringBuffer sb = new StringBuffer();
        while (length > 0) {
            if (index <= 1) {
                break;
            }
            div = (div - 1) / 10;
            index -= 1;
            int t = (index - 1) / div;
            index = index % div;
            sb.append(t);
        }
        sb.insert(0, start);
        return Integer.valueOf(sb.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findKthNumber(100, 10));
    }

}
