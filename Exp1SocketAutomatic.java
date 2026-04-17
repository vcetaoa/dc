import java.io.*;
import java.net.*;

public class Exp1SocketAutomatic {
    public static void main(String[] args) throws Exception {
        System.out.println("Experiment 1: Inter-process communication using socket programming (Automatic)");
        
        // Simple Server Thread
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(5001)) { // Using 5001 to avoid conflicts
                System.out.println("Server is waiting for connection...");
                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("Server Received: " + in.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Simple Client Thread
        Thread.sleep(1000); // Wait briefly for server to start
        try (Socket socket = new Socket("localhost", 5001)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Hello from Client!");
            System.out.println("Client sent the message automatically.");
        }
    }
}
