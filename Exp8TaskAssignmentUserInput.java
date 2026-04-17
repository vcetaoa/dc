import java.util.Scanner;

public class Exp8TaskAssignmentUserInput {
    public static void main(String[] args) {
        System.out.println("Experiment 8: Implement task assignment approach (User Input)");
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of tasks: ");
        int numTasks = scanner.nextInt();
        
        System.out.print("Enter number of processors: ");
        int numProcessors = scanner.nextInt();
        
        int[][] execCost = new int[numTasks][numProcessors];
        
        System.out.println("\nEnter execution costs for each task on each processor:");
        for (int i = 0; i < numTasks; i++) {
            System.out.println("-- For Task " + i + " --");
            for (int p = 0; p < numProcessors; p++) {
                System.out.print("Cost on Processor " + p + ": ");
                execCost[i][p] = scanner.nextInt();
            }
        }
        
        int totalOptimalCost = 0;
        System.out.println("\nCost matrix entered:");
        for (int i = 0; i < numTasks; i++) {
            System.out.print("Task " + i + " -> ");
            for (int p = 0; p < numProcessors; p++) {
                System.out.print("P" + p + ": " + execCost[i][p] + " | ");
            }
            System.out.println();
        }
        
        System.out.println("\nAssigning tasks to minimize overall execution cost...");
        
        // Simple assignment: Each task takes minimum cost
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
        scanner.close();
    }
}
