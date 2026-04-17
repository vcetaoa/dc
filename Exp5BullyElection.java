import java.util.Scanner;
import java.util.ArrayList;

public class Exp5BullyElection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();
        
        int crashed = n; // The highest is usually the coordinator
        System.out.println("Current Coordinator: " + crashed);
        System.out.println("Process " + crashed + " crashed.\n");
        
        System.out.print("Enter process that starts election: ");
        int initiator = scanner.nextInt();
        
        if (initiator == crashed || initiator > n || initiator < 1) {
            System.out.println("Invalid initiator process!");
            System.exit(0);
        }
        
        System.out.println("\nProcess " + initiator + " starts election");
        
        ArrayList<Integer> activeProcesses = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i != crashed) {
                activeProcesses.add(i);
            }
        }
        
        // Simulating the Bully algorithm behavior simply for console output
        int currentInitiator = initiator;
        while (true) {
            boolean higherResponded = false;
            for (int i = currentInitiator + 1; i <= n; i++) {
                if (i != crashed) {
                    System.out.println("Process " + currentInitiator + " sends election message to Process " + i);
                }
            }
            
            for (int i = currentInitiator + 1; i <= n; i++) {
                if (i != crashed) {
                    System.out.println("Process " + i + " replies OK to Process " + currentInitiator);
                    higherResponded = true;
                    currentInitiator = i; // The highest responding node takes over
                    break; 
                }
            }
            
            if (!higherResponded) {
                break;
            }
        }
        
        System.out.println("Active Processes: " + activeProcesses);
        System.out.println("Process " + currentInitiator + " elected as Coordinator");
        System.out.println("Current Coordinator: " + currentInitiator);
        
        scanner.close();
    }
}
