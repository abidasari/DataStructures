package dandc;

/**
 * 
 * @author adasari
 *
 */

public class MaxSumSubSequence {
	
	public int maxSubSeqKickoff(int[] a){
		if(a.length == 0)
			return 0;
		return maxSumSubSeq(a, 0, a.length - 1);
	}
	
	public int maxSumSubSeq(int[] a, int low, int high){
		if(low == high)
			return a[low];
		int sumLeftOfMid = Integer.MIN_VALUE, sumRightOfMid = Integer.MIN_VALUE, sum = 0;
		int mid = low + (high - low) / 2; 
		int maxLeftSum = maxSumSubSeq(a, low, mid);
		int maxRightSum = maxSumSubSeq(a, mid + 1, high);
		for(int i = mid; i >= low; i--){
			sum += a[i];
			sumLeftOfMid = (sum > sumLeftOfMid) ? sum : sumLeftOfMid;
		}
		sum = 0;
		for(int i = mid + 1; i <= high; i++){
			sum += a[i];
			sumRightOfMid = (sum > sumRightOfMid) ? sum : sumRightOfMid;
		}
		return Integer.max((sumRightOfMid + sumLeftOfMid), Integer.max(maxLeftSum, maxRightSum));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSumSubSequence obj = new MaxSumSubSequence();
		int[] input = {-2, 11, -4, 13, -5, 2};
		System.out.println(obj.maxSubSeqKickoff(input));

	}

}
