import java.util.Scanner;

public class Exp6TokenRingMutualExclusion {
    public static void main(String[] args) {
        System.out.println("Experiment 6: Implement Token Ring Mutual Exclusion algorithm");
        
        Scanner scanner = new Scanner(System.in);
        int nodes = 5; // Suppose we have 5 nodes indexed 0 to 4
        System.out.println("Simulating token ring with " + nodes + " nodes (0 to 4).");
        int tokenHolder = 0; // Node 0 starts with the token.
        
        System.out.println("Initially, the Token is at Node " + tokenHolder);
        
        System.out.print("Enter the node index that wants to enter critical section: ");
        int requestingNode = 3; // fallback default
        if (scanner.hasNextInt()) {
            requestingNode = scanner.nextInt();
        } else {
            System.out.println("Proceeding with default Node " + requestingNode);
        }
        
        if (requestingNode < 0 || requestingNode >= nodes) {
            System.out.println("Invalid node.");
            return;
        }
        
        System.out.println("Node " + requestingNode + " wants to enter critical section.");
        
        // Pass the token until it reaches the requesting node
        while (tokenHolder != requestingNode) {
            System.out.println("Token at Node " + tokenHolder + ", passing to next node...");
            // Simulate processing/passing delay
            try { Thread.sleep(500); } catch(Exception ignored) {} 
            tokenHolder = (tokenHolder + 1) % nodes;
        }
        
        System.out.println("-> Node " + tokenHolder + " got the token!");
        System.out.println("-> Node " + tokenHolder + " enters critical section and starts executing.");
        
        try { Thread.sleep(2000); } catch(Exception ignored) {} 
        
        System.out.println("-> Node " + tokenHolder + " exits critical section.");
        System.out.println("Node " + tokenHolder + " releases token and passes it to next node.");
        tokenHolder = (tokenHolder + 1) % nodes;
        System.out.println("Token is now at Node " + tokenHolder);
        
        scanner.close();
    }
}
