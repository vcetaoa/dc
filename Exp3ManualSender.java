import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Exp3ManualSender {
    public static void main(String[] args) {
        System.out.println("Experiment 3: Manual Multicast Sender");
        Scanner scanner = new Scanner(System.in);
        
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName("230.0.0.0");
            System.out.println("Ready to send to multicast group 230.0.0.0 on port 4446.");
            System.out.println("Type your messages below (type 'exit' to quit and signal receiver to stop):");
            
            while (true) {
                System.out.print("> ");
                String message = scanner.nextLine();
                byte[] buf = message.getBytes();
                
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);
                
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
            }
            System.out.println("Sender closed.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
