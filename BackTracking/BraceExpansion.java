package BackTracking;

import java.util.*;

public class BraceExpansion {

    // Function to perform brace expansion using backtracking
    public static List<String> expand(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        Collections.sort(result); // Sort the result in lexicographical order
        return result;
    }

    // Recursive backtracking function
    private static void backtrack(String s, int index, StringBuilder current, List<String> result) {
        // Base case: if we reach the end of the string, add the current result to the list
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        char c = s.charAt(index);

        if (c == '{') {
            // When encountering '{', we extract the options inside the braces
            int closeBraceIndex = findClosingBrace(s, index);
            String options = s.substring(index + 1, closeBraceIndex);
            String[] parts = options.split(",");

            // Try all options inside the braces
            for (String part : parts) {
                current.append(part);
                backtrack(s, closeBraceIndex + 1, current, result); // Recur with the next part of the string
                current.setLength(current.length() - part.length()); // Backtrack
            }
        } else {
            // If it's a normal character, just append it to the current string
            current.append(c);
            backtrack(s, index + 1, current, result); // Recur for the next character
        }
    }

    // Function to find the index of the closing '}' for a given '{'
    private static int findClosingBrace(String s, int index) {
        int openBraces = 1; // We already encountered one '{'
        for (int i = index + 1; i < s.length(); i++) {
            if (s.charAt(i) == '{') openBraces++;
            if (s.charAt(i) == '}') openBraces--;
            if (openBraces == 0) return i; // Found the corresponding '}'
        }
        return -1; // In case no closing brace is found, which shouldn't happen in this context
    }

    public static void main(String[] args) {
        String s = "a{b,c}{d,e}";
        List<String> result = expand(s);

        // Print the result
        for (String str : result) {
            System.out.println(str);
        }
    }
}
