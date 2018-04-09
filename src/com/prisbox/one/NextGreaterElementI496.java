/**
 * 
 */

package com.prisbox.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LO
 *
 */
public class NextGreaterElementI496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            int num = nums2[i];
            if(i+1>nums2.length-1){
                map.put(num, -1);
                continue;
            }
            if(nums2[i+1]>num){
                map.put(num, i+1);
            }
            if(nums2[i+1]<num){
                int t = i+1;
                while(true){
                    if(map.get(nums2[t])==null||map.get(nums2[t])==-1){
                        map.put(num, -1);
                        break;
                    }else{
                        if(nums2[map.get(nums2[t])]>num){
                            map.put(num, map.get(nums2[t]));
                            break;
                        }else{
                            t = map.get(nums2[t]);
                            continue;
                        }
                    }
                }
            }
        }
        int[] result = new int[nums1.length];
        for(int j=0;j<nums1.length;j++){
            result[j] = map.get(nums1[j])==-1?-1:nums2[map.get(nums1[j])];
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {4,1,2};
        int[] b = {1,3,4,2};
        NextGreaterElementI496 v = new NextGreaterElementI496();
        int[] c = v.nextGreaterElement(a,b);
        System.out.println(c);
    }

}
