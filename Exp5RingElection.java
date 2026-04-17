import java.util.ArrayList;
import java.util.Scanner;

public class Exp5RingElection {
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
        int next = initiator;
        int newCoordinator = initiator;
        
        while (true) {
            activeProcesses.add(next);
            
            if (next > newCoordinator && next != crashed) {
                newCoordinator = next;
            }
            
            // Move to next node in ring
            next = (next % n) + 1;
            
            // Skip the crashed node
            if (next == crashed) {
                next = (next % n) + 1;
            }
            
            // Stop when we complete the ring back to the initiator
            if (next == initiator) {
                break;
            }
        }
        
        System.out.println("Active Processes: " + activeProcesses);
        System.out.println("Process " + newCoordinator + " elected as Coordinator");
        System.out.println("Current Coordinator: " + newCoordinator);
        
        scanner.close();
    }
}
