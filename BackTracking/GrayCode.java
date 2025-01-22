package BackTracking;

import java.util.*;

public class GrayCode {
    public List<Integer> generateGrayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // Total possible values for n bits is 2^n
        int totalNumbers = 1 << n;
        
        // Add first number (0)
        result.add(0);
        
        // Keep track of used numbers to avoid duplicates
        Set<Integer> used = new HashSet<>();
        used.add(0);
        
        // Generate the sequence using backtracking
        generateGrayCodeHelper(result, used, n, totalNumbers);
        
        return result;
    }
    
    private boolean generateGrayCodeHelper(List<Integer> result, Set<Integer> used, int n, int total) {
        // If we've found all numbers, check if the last number differs by only one bit from first
        if (result.size() == total) {
            // Check if last and first number differ by only one bit
            return differsByOneBit(result.get(0), result.get(result.size() - 1));
        }
        
        // Get the last number in sequence
        int current = result.get(result.size() - 1);
        
        // Try changing each bit position
        for (int i = 0; i < n; i++) {
            // Toggle bit at position i
            int next = current ^ (1 << i);
            
            // If this number hasn't been used yet
            if (!used.contains(next)) {
                result.add(next);
                used.add(next);
                
                // Recursively try to complete the sequence
                if (generateGrayCodeHelper(result, used, n, total)) {
                    return true;
                }
                
                // Backtrack if this path doesn't work
                result.remove(result.size() - 1);
                used.remove(next);
            }
        }
        
        return false;
    }
    
    // Helper method to check if two numbers differ by exactly one bit
    private boolean differsByOneBit(int a, int b) {
        int xor = a ^ b;
        return xor != 0 && (xor & (xor - 1)) == 0;
    }
    
    // Main method to test the Gray code generator
    public static void main(String[] args) {
        GrayCode generator = new GrayCode();
        int n = 3; // Generate Gray code for 3 bits
        List<Integer> grayCode = generator.generateGrayCode(n);
        
        System.out.println("Gray Code Sequence for " + n + " bits:");
        for (int i = 0; i < grayCode.size(); i++) {
            System.out.printf("%d: %s%n", grayCode.get(i), 
                String.format("%" + n + "s", Integer.toBinaryString(grayCode.get(i))).replace(' ', '0'));
        }
    }
}