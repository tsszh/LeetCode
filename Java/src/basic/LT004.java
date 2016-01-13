package basic;

import java.util.*;

public class LT004 {
	public static void main ( String[] args ) {
		//int[] nums1 = randomFill(2);
		//int[] nums2 = randomFill(3);
		int[] nums1 = new int[] {1,2,3};
		int[] nums2 = new int[] {4,5,6};
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Double ans = findMedianSortedArrays(nums1,nums2);
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(ans);
	}
	public static int[] randomFill ( int capacity ) {
		if ( capacity == 0 ) 
			return new int[0];
		Random gen = new Random();
		int[] num = new int[capacity];
		for ( int i=0; i<num.length; i++ ) {
			num[i] = gen.nextInt(10);
		}
		return num;
	}
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {		
		if ( nums1.length > nums2.length )
        	return findMedianSortedArrays(nums2,nums1);
        int n = nums1.length;
        int s1 =0, e1 = nums1.length-1, s2 = 0, e2 = nums2.length-1; 
        while ( n > 1 ) {
        	int l1 = (s1+e1)/2, r1 = (s1+e1+1)/2;
        	int l2 = (s2+e2)/2, r2 = (s2+e2+1)/2;
        	if ( nums1[r1] < nums2[l2] ) {
        		s1 += n/2;
        		e2 -= n/2;
        	} else if ( nums1[l1] > nums2[r2] ) {
        		e1 -= n/2;
        		s2 += n/2;
        	} else {
        		if ( l1 == r1 )
        			return nums1[l1];
        		else if ( l2 == r2 )
        			return nums2[l2];
        		else
        			return (double)(
        					(nums1[l1]>nums2[l2]?nums1[l1]:nums2[l2])+
        					(nums1[r1]<nums2[r2]?nums1[r1]:nums2[r2])
        					)/2;
        	}
        	n -= n/2;
        }
        if ( n == 0 )
        	return (double)(nums2[nums2.length/2]+nums2[(nums2.length-1)/2])/2;
        if ( s2 == e2 )
        	return (double)(nums1[s1]+nums2[s2])/2;
        else {
        	int m2 = (s2+e2)/2;
        	if ( (e2-s2+1)%2 == 0 ) {
        		if ( nums1[s1] <= nums2[m2] )
        			return nums2[m2];
        		else if ( nums1[s1] >= nums2[m2+1] )
        			return nums2[m2+1];
        		else
        			return nums1[s1];
        	} else {
        		if ( nums1[s1] <= nums2[m2-1] )
        			return (double)(nums2[m2-1]+nums2[m2])/2;
        		else if ( nums1[s1] >= nums2[m2+1] )
        			return (double)(nums2[m2+1]+nums2[m2])/2;
        		else
        			return (double)(nums1[s1]+nums2[m2])/2;
        			
        	}
        }
	}
}











