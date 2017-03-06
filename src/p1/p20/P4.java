package p1.p20;

import java.util.Arrays;

public class P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,3};
		int[] b = {2};
		System.out.println(P4.findMedianSortedArrays(a, b));
		int[] a1 = {1,2};
		int[] b1 = {3,4};
		System.out.println(P4.findMedianSortedArrays(a1, b1));

	}
	static double findKth(int a[], int m, int b[], int n, int k){
		//always assume that m is equal or smaller than n
		if (m > n)
			return findKth(b, n, a, m, k);
		if (m == 0)
			return b[k - 1];
		if (k == 1)
			return a[0] > b[0] ? b[0]: a[0];
		//divide k into two parts
		int pa = k / 2 > m ? m : k / 2, pb = k - pa;
		if (a[pa - 1] < b[pb - 1])
			return findKth(Arrays.copyOfRange(a, pa, m), m - pa, b, n, k - pa);
		else if (a[pa - 1] > b[pb - 1])
			return findKth(a, m, Arrays.copyOfRange(b, pb, n), n - pb, k - pb);
		else
			return a[pa - 1];
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int total = m + n;
		if (total%2 == 1)
			return findKth(nums1, m, nums2, n, total / 2 + 1);
		else
			return (findKth(nums1, m, nums2, n, total / 2) + findKth(nums1, m, nums2, n,
					total / 2 + 1)) / 2;
	}
}