import java.rmi.*;
import java.util.Scanner;

public class Exp2RMIManualClient {
    public static void main(String[] args) {
        System.out.println("Experiment 2: Manual RMI Client");
        Scanner scanner = new Scanner(System.in);
        try {
            // Lookup the service using the nested interface path on port 1100
            Exp2RMIManualServer.MyManualRemote stub = (Exp2RMIManualServer.MyManualRemote) Naming.lookup("rmi://localhost:1100/RemoteHelloManual");
            System.out.println("Connected to RMI Server! Type your messages below (type 'exit' to quit):");
            
            while(true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                
                if(input.equalsIgnoreCase("exit")) {
                    break;
                }
                
                // Call remote method with manual input
                String response = stub.sendMessage(input);
                System.out.println(response);
            }
            System.out.println("Client Closed.");
            
        } catch(Exception e) {
            System.out.println("Could not connect to the server. Make sure Exp2RMIManualServer is running first!");
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
