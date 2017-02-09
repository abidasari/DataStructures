package arrays;

/**
 * 
 * @author adasari
 *
 */

public class MedianInTwoSortedArrays {
	
	public double medianInTwoSortedArrays(int[] A, int[] B){
		int lenA = A.length, lenB = B.length;
		if((lenA + lenB )%2 == 0 ){
			double res1 = (double) findMedianInSortedArrays(A, 0, lenA, B, 0, lenB, (lenA + lenB)/2 );
			double res2 = (double) findMedianInSortedArrays(A, 0, lenA, B, 0, lenB, (lenA + lenB)/2 + 1);
			return (res1 + res2)/2;
		} else {
			return (double) findMedianInSortedArrays(A, 0, lenA, B, 0, lenB, (lenA + lenB + 1)/2 );
		}
	}
	
	public double findMedianInSortedArrays(int[] A, int startA, int endA, int[] B, int startB, int endB, int k){
		int lenA = endA - startA, lenB = endB - startB;
		if(lenA <= 0)
			return B[startB + k - 1];
		if(lenB <= 0)
			return A[startA + k - 1];
		if(k == 1)
			return (A[startA] > B[startB] ? B[startB] : A[startA]);
		int midA = (startA + endA) / 2, midB = (startB + endB)/2;
		if(A[midA] <= B[midB]){
			if(lenA/2 + lenB/2 + 1 >= k)
				return findMedianInSortedArrays(A, startA, endA, B, startB, midB, k);
			else
				return findMedianInSortedArrays(A, midA + 1, endA, B, startB, endB, k - lenA/2 -1);
		} else {
			if(lenA/2 + lenB/2 + 1 >= k)
				return findMedianInSortedArrays(A, startA, midA, B, startB, endB, k);
			else
				return findMedianInSortedArrays(A, startA, endA, B, midB + 1, endB, k - lenB/2 - 1);
		}
	}

	public static void main(String[] args) {
		MedianInTwoSortedArrays obj = new MedianInTwoSortedArrays();
		int[] A = {1,3,5,7}, B = {2,4,6,8};
		System.out.println(obj.medianInTwoSortedArrays(A, B));
	}

}
