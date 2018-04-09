/**
 * 
 */

package com.prisbox.one;

/**
 * @author admin
 *
 */
public class IsValidSerialization331 {

    public boolean isValidSerialization(String preorder) {
        if(preorder.startsWith("#")){
            return preorder.length() == 1;
        }
        String[] t = preorder.split(",");
        int a = 0;
        int b = 0;
        // int seqa = 0;
        for(int i = 0; i < t.length; i++){
            String current = t[i];
            if(current.equals("#")){
                b++;
            }else{
                a++;
            }
            if(b == a + 1 && i != t.length - 1){
                return false;
            }
        }
        if(b == a + 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
