/*
    Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
    
    A string such as "word" contains only the following valid abbreviations: ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

    Notice that only the above abbreviations are valid abbreviations of the string "word". 
    Any other string is not a valid abbreviation of "word".

    Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

- Input Format:
    -------------
    Line-1: A string, S contains only lowercase letters
    Line-2: A string, abbr contains lowercase letters and digits

- Output Format:
    --------------
    Line-1: A boolean value.

-Sample Input-1:
    ---------------
    internationalization
    i12iz4n

Sample Output-1:
---------------
    true

Sample Input-2:
---------------
    apple
    a2e

Sample Output-2:
---------------
    false

Time Complexity: O(n) where n=max(len(word),len(abbr))
Auxiliary Space:  O(1).
 */
package TwoPointers;

import java.util.*;

public class ValidWordAbbr {

    public static boolean check(String str1, String str2) {
        // string, st2n1
        int p1 = 0, p2 = 0;
        while (p1 < str1.length() && p2 < str2.length()) {
            // check if the next char is digit
            if (Character.isDigit(str2.charAt(p2))) {
                // if it's a leading 0 don't include it
                if (str2.charAt(p2) == '0') {
                    return false;
                }
                int num = 0;
                // check if it has leading numbers
                while (p2 < str2.length() && Character.isDigit(str2.charAt(p2))) {
                    // can't allow 0
                    num = num * 10 + (str2.charAt(p2) - '0');
                    p2++;
                }
                p1 += num;
                continue;
            } else if (str1.charAt(p1) != str2.charAt(p2)) {
                return false;
            }
            p1++;
            p2++;
        }
        return p1 == str1.length() && p2 == str2.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(check(str1, str2));
    }
}
