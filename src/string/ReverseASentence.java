package string;

/**
 * 
 * @author adasari
 *
 */

public class ReverseASentence {
	public String reverseSentence(String s){
		if(s == "" || s == null)
			return s;
		StringBuilder buffer = new StringBuilder();
		s = reverseWord(s, 0, s.length() - 1);
		for(int i = 0, start = 0; i < s.length();){
			if(i < s.length() && s.charAt(i) == ' '){
				start++; i++;
			} else {
				while(i < s.length() && s.charAt(i) != ' ')
					i++;
				String revWord = reverseWord(s, start, i - 1);
				buffer.append(revWord + " ");
				start = i;
			}
//			System.out.println(buffer.toString() + "  " + start + "  " + i );
		}
		
		return buffer.toString().trim();
	}
	
	
	public String reverseWord(String s, int start, int end){
		if(s == "" || s == null || s == " " || s == "  ")
			return s;
		String out;
		char[] chars = new char[s.length()];
		for(int i = end, j = 0; i >= start; i--, j++){
			chars[j] = s.charAt(i);
		}
		out = new String(chars);
		return out;
	}
	
	public static void main(String[] args){
		ReverseASentence obj = new ReverseASentence();
		String test = "This is a test String";
		System.out.println(test);

		System.out.println(obj.reverseSentence(test));
	}
}
