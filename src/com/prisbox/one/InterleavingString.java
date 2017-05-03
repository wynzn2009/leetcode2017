/**
 * 
 */
package com.prisbox.one;

/**
 * @author admin
 *
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        int sl = s1.length();
        int st = s2.length();
        if(s3.length()!=sl+st){
        	return false;
        }
        boolean[][] matrix = new boolean[sl+1][st+1];
        matrix[0][0] = true;
        for(int i=1;i<=sl;i++){
        	matrix[i][0] = matrix[i-1][0]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }
        for(int i=1;i<=st;i++){
        	matrix[0][i] = matrix[0][i-1]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }
        for(int i=1;i<=sl;i++){
        	for(int j=1;j<=st;j++){
        		matrix[i][j] = (matrix[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)))
        				||(matrix[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)));
        	}
        }
        return matrix[sl][st];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString i = new InterleavingString();
		i.isInterleave("", "b", "b");
	}

}
