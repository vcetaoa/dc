import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Exp1SocketManualClient {
    public static void main(String[] args) {
        System.out.println("Experiment 1: Manual Client");
        Scanner scanner = new Scanner(System.in);
        
        try (Socket socket = new Socket("localhost", 5000)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected to Server! Type your messages below (type 'exit' to quit):");
            
            while (true) {
                System.out.print("> ");
                String message = scanner.nextLine();
                out.writeUTF(message);
                out.flush();
                
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }
            System.out.println("Client Closed.");
        } catch (ConnectException e) {
            System.out.println("Could not connect to the server. Make sure Exp1SocketManualServer is running first!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
