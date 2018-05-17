package leetcode;

/**
 * Created by I321049 on 2018/5/15.
 * Note:
 * Notice the special case such as null value
 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] arg){
        Solution solution = new Solution();
        double num = 0.0;
        int []nums1 = {1,2};
        int []nums2 = {3,4};
        num = solution.findMedianSortedArrays(nums1, nums2);
        System.out.print(num);
    }
}


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double medium = 0.0;
        if(nums1.length == 0){
            return nums2.length%2 == 0?(((double)nums2[nums2.length/2]+(double)nums2[nums2.length/2-1])/2):(nums2[nums2.length/2]);
        }
        if(nums2.length == 0){
            return nums1.length%2 == 0?(((double)nums1[nums1.length/2]+(double)nums1[nums1.length/2-1])/2):(nums1[nums1.length/2]);
        }
        int []numall = new int[nums1.length+nums2.length];
        int []longer = nums1.length >= nums2.length ? nums1 : nums2;
        int []shorter = nums1.length < nums2.length ? nums1 : nums2;
        int j1 = 0;
        int j2 = 0;
        for(int i = 0; i < longer.length + shorter.length; i++){
           if(j1 < shorter.length && j2 < longer.length){
               if(longer[j2]<shorter[j1]){
                   numall[j2+j1] = longer[j2];
                   j2++;
               }else {
                   numall[j2+j1] = shorter[j1];
                   j1++;
               }
           }else if (j1 >= shorter.length){
               numall[j2+j1] = longer[j2];
               j2++;
           }else if (j2 >= longer.length){
               numall[j2+j1] = shorter[j1];
               j1++;
           }

        }
        int lengthall = numall.length;
        if(lengthall%2==0){
            medium = ((double)numall[lengthall/2] + (double)numall[lengthall/2 - 1])/2;
        }else{
            medium = numall[lengthall/2];
        }
        return medium;
    }
}