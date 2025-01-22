package BackTracking;

import java.util.*;

class CampusBikes {
    private int minTotalDistance = Integer.MAX_VALUE;
    private int[] bestAssignment;
    private boolean[] usedBikes;
    
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;    // number of workers
        int m = bikes.length;      // number of bikes
        
        bestAssignment = new int[n];
        int[] currentAssignment = new int[n];
        usedBikes = new boolean[m];
        
        // Start backtracking with first worker
        backtrack(workers, bikes, 0, 0, currentAssignment);
        
        return bestAssignment;
    }
    
    private void backtrack(int[][] workers, int[][] bikes, int workerIndex, 
                          int currentDistance, int[] currentAssignment) {
        int n = workers.length;
        
        // Base case: all workers have been assigned bikes
        if (workerIndex == n) {
            if (currentDistance < minTotalDistance) {
                minTotalDistance = currentDistance;
                System.arraycopy(currentAssignment, 0, bestAssignment, 0, n);
            }
            return;
        }
        
        // Pruning: if current distance exceeds minimum, no need to continue
        if (currentDistance >= minTotalDistance) {
            return;
        }
        
        // Try assigning each available bike to current worker
        for (int j = 0; j < bikes.length; j++) {
            if (!usedBikes[j]) {
                usedBikes[j] = true;
                currentAssignment[workerIndex] = j;
                
                int distance = manhattanDistance(workers[workerIndex], bikes[j]);
                
                backtrack(workers, bikes, workerIndex + 1, 
                         currentDistance + distance, currentAssignment);
                
                // Backtrack
                usedBikes[j] = false;
            }
        }
    }
    
    private int manhattanDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    // Helper method to print assignment with distances
    private void printAssignment(int[][] workers, int[][] bikes, int[] assignment) {
        System.out.println("\nBike Assignments:");
        int totalDistance = 0;
        
        for (int i = 0; i < assignment.length; i++) {
            int bikeIndex = assignment[i];
            int distance = manhattanDistance(workers[i], bikes[bikeIndex]);
            totalDistance += distance;
            
            System.out.printf("Worker %d (%d,%d) → Bike %d (%d,%d) | Distance: %d%n",
                i, workers[i][0], workers[i][1],
                bikeIndex, bikes[bikeIndex][0], bikes[bikeIndex][1],
                distance);
        }
        
        System.out.println("Total Distance: " + totalDistance);
    }
    
    public static void main(String[] args) {
        CampusBikes solution = new CampusBikes();
        
        // Test case
        int[][] workers = {
            {0, 0},
            {2, 1}
        };
        
        int[][] bikes = {
            {1, 2},
            {3, 3}
        };
        
        System.out.println("Initial Setup:");
        System.out.println("Workers: ");
        for (int i = 0; i < workers.length; i++) {
            System.out.printf("Worker %d: (%d,%d)%n", 
                i, workers[i][0], workers[i][1]);
        }
        
        System.out.println("\nBikes: ");
        for (int i = 0; i < bikes.length; i++) {
            System.out.printf("Bike %d: (%d,%d)%n", 
                i, bikes[i][0], bikes[i][1]);
        }
        
        int[] assignment = solution.assignBikes(workers, bikes);
        solution.printAssignment(workers, bikes, assignment);
    }
}