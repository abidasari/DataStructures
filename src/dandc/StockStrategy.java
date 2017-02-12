package dandc;

/**
 * 
 * @author adasari
 *
 */

public class StockStrategy {
	
	public static class Result{
		public int profit;
		public int buyDate;
		public int sellDate;
		public Result(int profit, int buyDate, int sellDate) {
			super();
			this.profit = profit;
			this.buyDate = buyDate;
			this.sellDate = sellDate;
		}
		@Override
		public String toString(){
			return new String("profit: " + profit + ", buy on: " + buyDate + ", sell on: " + sellDate);
		}
	}
	
	public Result stockStrategyKickOff(int[] in){
		return stockStrategy(in, 0, in.length - 1);
	}
	
	public Result stockStrategy(int[] a, int left, int right){
		if(left == right - 1){
				return new Result(a[right] - a[left], left, right);
		}
		int mid = left + (right - left) / 2;
		Result leftResult = stockStrategy(a, left, mid);
		Result rightResult = stockStrategy(a, mid, right);
		int minLeft = min(a, left, mid);
		int maxRight = max(a, mid, right);
		int profit = a[maxRight] - a[minLeft];
		if(leftResult.profit > Integer.max(profit, rightResult.profit))
			return leftResult;
		else if (rightResult.profit > Integer.max(profit, leftResult.profit))
			return rightResult;
		else
			return new Result(profit, minLeft, maxRight);
	}
	
	public int min(int[] a, int start, int end){
		int min = Integer.MAX_VALUE, minIndex = 0;
		for(int i = start; i <= end; i++ )
			if(a[i] < min){
				min = a[i]; minIndex = i;
			}
		return minIndex;
	}
	
	public int max(int[] a, int start, int end){
		int max = Integer.MIN_VALUE, maxIndex = 0;
		for(int i = start; i <= end; i++ )
			if(a[i] > max){
				max = a[i]; maxIndex = i;
			}
		return maxIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockStrategy obj = new StockStrategy();
		int[] in = {2, 1, 5, 7, 9, 4, -2, 3};
		System.out.println(obj.stockStrategyKickOff(in));
	}

}
