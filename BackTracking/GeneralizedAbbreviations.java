package BackTracking;

import java.util.*;

public class GeneralizedAbbreviations {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(word, 0, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String word, int position, int count, StringBuilder current, List<String> result) {
        // Store the length of StringBuilder before adding new characters
        int len = current.length();
        
        // Base case: reached the end of word
        if (position == word.length()) {
            // If there's a count pending, append it
            if (count > 0) {
                current.append(count);
            }
            result.add(current.toString());
            // Restore StringBuilder to original state
            current.setLength(len);
            return;
        }
        
        // Option 1: Skip current character (abbreviate it)
        backtrack(word, position + 1, count + 1, current, result);
        
        // Option 2: Keep current character
        // First append count if exists
        if (count > 0) {
            current.append(count);
        }
        current.append(word.charAt(position));
        backtrack(word, position + 1, 0, current, result);
        
        // Restore StringBuilder to original state
        current.setLength(len);
    }
    
    // Helper method to print abbreviations with explanations
    private void printAbbreviationWithExplanation(String original, String abbr) {
        System.out.printf("%-10s -> ", abbr);
        
        int i = 0;  // index for original word
        int j = 0;  // index for abbreviation
        
        StringBuilder explanation = new StringBuilder();
        
        while (j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                // Extract the complete number
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                explanation.append(String.format("%d letters skipped (%s), ", 
                    num, original.substring(i, i + num)));
                i += num;
            } else {
                explanation.append(String.format("keep '%c', ", abbr.charAt(j)));
                i++;
                j++;
            }
        }
        
        // Remove trailing comma and space
        if (explanation.length() > 2) {
            explanation.setLength(explanation.length() - 2);
        }
        
        System.out.println(explanation.toString());
    }
    
    public static void main(String[] args) {
        GeneralizedAbbreviations generator = new GeneralizedAbbreviations();
        String word = "word";
        
        System.out.println("Generating all possible abbreviations for: " + word);
        System.out.println("\nAbbreviation Explanations:");
        System.out.println("-----------------------------");
        
        List<String> abbreviations = generator.generateAbbreviations(word);
        for (String abbr : abbreviations) {
            generator.printAbbreviationWithExplanation(word, abbr);
        }
        
        System.out.println("\nTotal number of abbreviations: " + abbreviations.size());
    }
}