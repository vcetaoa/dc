import java.io.*;
import java.net.*;

public class Exp1SocketManualServer {
    public static void main(String[] args) {
        System.out.println("Experiment 1: Manual Server");
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Server is waiting for connection on port 5000...");
            
            // Wait for client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");
            
            DataInputStream in = new DataInputStream(socket.getInputStream());
            String message = "";
            
            // Continuously read messages from the client
            while (!message.equalsIgnoreCase("exit")) {
                try {
                    message = in.readUTF();
                    System.out.println("Client says: " + message);
                } catch (EOFException e) {
                    System.out.println("Client disconnected.");
                    break;
                }
            }
            
            socket.close();
            System.out.println("Server Closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
