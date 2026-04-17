public class Exp8TaskAssignment {
    public static void main(String[] args) {
        System.out.println("Experiment 8: Implement task assignment approach");
        
        // We have N tasks and M processors.
        // Array configuration: execCost[TaskID][ProcessorID]
        // This array represents the cost of executing Task i on Processor j
        int[][] execCost = {
            {5, 10},  // Task 0: Cost 5 on P0, 10 on P1
            {2, 4},   // Task 1: Cost 2 on P0,  4 on P1
            {8, 3},   // Task 2: Cost 8 on P0,  3 on P1
            {4, 4},   // Task 3: Cost 4 on P0,  4 on P1
            {12, 6}   // Task 4: Cost 12 on P0, 6 on P1
        };
        
        int numTasks = execCost.length;
        int numProcessors = execCost[0].length;
        int totalOptimalCost = 0;
        
        System.out.println("Cost matrix for Task Assignment (Tasks vs Processors):");
        for (int i = 0; i < numTasks; i++) {
            System.out.println("Task " + i + " -> P0: " + execCost[i][0] + " | P1: " + execCost[i][1]);
        }
        
        System.out.println("\nAssigning tasks to minimize overall execution cost...");
        
        // Simple assignment: Each task takes minimum cost independent of others.
        for (int i = 0; i < numTasks; i++) {
            int minCost = Integer.MAX_VALUE;
            int assignedProcessor = -1;
            
            for (int p = 0; p < numProcessors; p++) {
                if (execCost[i][p] < minCost) {
                    minCost = execCost[i][p];
                    assignedProcessor = p;
                }
            }
            
            System.out.println("- Task " + i + " is assigned to Processor " + assignedProcessor + " (Cost: " + minCost + ")");
            totalOptimalCost += minCost;
        }
        
        System.out.println("\nTotal Serial Execution Cost minimized: " + totalOptimalCost);
    }
}
