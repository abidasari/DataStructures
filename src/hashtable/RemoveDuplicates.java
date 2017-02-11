package hashtable;

import java.util.Arrays;

public class RemoveDuplicates {
	
	public String removeDuplicates(String s){
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			String character = s.substring(i, i+1);
			if(str.indexOf(character) == -1){
				str.append(character);
			}
		}
		return str.toString();
 	}
	
	public void removeDuplicates(char[] c){
		if(c.length == 1 || c.length == 0)
			return;
		Arrays.sort(c);
		int tail = 0;
		for(int i = 1; i < c.length; i++){
			if(c[i] == c[tail])
				continue;
			else{
				c[++tail] = c[i];
			}
		}
		while(tail < c.length - 1)
			c[++tail] = '\0';
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c[] = {'a', 'b', 'a', 'b', 'c', 'd', 'd', 'e'};
		RemoveDuplicates obj = new RemoveDuplicates();
		obj.removeDuplicates(c);
		System.out.println(obj.removeDuplicates(new String(c)));
		
	}

}
