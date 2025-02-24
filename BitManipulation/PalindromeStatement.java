/*
AlphaCipher is a string formed from another string by rearranging its letters

You are given a string S.
Your task is to check, can any one of the AlphaCipher is a palindrome or not.

Input Format:
-------------
A string S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
carrace

Sample Output-1:
----------------
true


Sample Input-2:
---------------
code

Sample Output-2:
----------------
false 
 */
package BitManipulation;

import java.util.*;

public class PalindromeStatement {

    public static boolean checkPalindrome(String str) {
        int bitVector = 0;
        // loop through the string and set the bit in the bitVector. `charArray` is used to convert the string to char array.
        for (char c : str.toCharArray()) {
            // c - 'a' gives, the index of the character in the alphabet. it'll be helpful to set the bit in the bitVector.
            int bitIndex = c - 'a';

            bitVector ^= (1 << bitIndex);
        }
        return bitVector == 0 || (bitVector & (bitVector - 1)) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(checkPalindrome(str));
    }
}
