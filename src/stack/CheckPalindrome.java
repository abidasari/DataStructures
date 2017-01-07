package stack;

import java.util.Stack;

/**
 * @author adasari
 */

public class CheckPalindrome {

    //given a string marked with an "X" as the mid-point check if it is a palindrome

    public boolean isPalindromeA(String input){ // uses iterative approach
        int i = 0, j = input.length() - 1;
        while(i < j && input.charAt(i) == input.charAt(j)){
            i++;
            j--;
        }
        if(i < j)
            return false;
        else
            return true;
    }

    public boolean isPalindromeB(String input){ // Stack Approach
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while(input.charAt(i) != 'X'){
            stack.push(input.charAt(i));
            i++;
        }
        i++;
        while(!stack.isEmpty()){
            if(input.charAt(i) != stack.pop())
                return false;
            i++;
        }
        if(i != input.length() - 1)
            return false;
        return true;
    }

    public static void main(String[] args) {
//        String test = "aabbaaabaXabaaabbaa";
        String test = "aXb";
        CheckPalindrome obj = new CheckPalindrome();

        System.out.println(test + " is a palindrome: " + obj.isPalindromeB(test) );

    }
}