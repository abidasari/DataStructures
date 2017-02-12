package dandc;

/**
 * 
 * @author adasari
 *
 */

public class KpowN {
	
	public double kPowN(double k, int n){
		if(n == 0)
			return 1.0;
		double half = kPowN(k, n / 2);
		if(n % 2 == 0)
			return half * half;
		else if(n > 0)
			return half * half * k;
		else
			return half * half / k;
	}

	public static void main(String[] args) {
		KpowN obj = new KpowN();
		System.out.println(obj.kPowN(4, 9));
	}

}
