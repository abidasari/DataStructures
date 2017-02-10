package string;

/**
 * 
 * @author adasari
 *
 */

public class PermutationsAndCombinations {
	public void combinations(String s){
		allCombinations("", s);
	}
	
	public void allCombinations(String prefix, String s){
		if(s.length() > 0){
			System.out.println(prefix + s.charAt(0));
			allCombinations(prefix + s.charAt(0), s.substring(1));
			allCombinations(prefix, s.substring(1));
		}
	}
	
	public void permutations(String s){
		allPermutations("", s);
	}
	
	public void allPermutations(String prefix, String s){
		if(s.length() == 0)
			System.out.println(prefix);
		else{
			for(int i = 0; i < s.length(); i++){
				allPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1));
			}
		}
	}
	
	
	
	public static void main(String[] args){
		PermutationsAndCombinations obj = new PermutationsAndCombinations();
		obj.combinations("abcd");
	}
}
