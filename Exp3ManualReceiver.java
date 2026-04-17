import java.net.*;
import java.io.*;

public class Exp3ManualReceiver {
    public static void main(String[] args) {
        System.out.println("Experiment 3: Manual Multicast Receiver");
        
        try (MulticastSocket socket = new MulticastSocket(4446)) {
            InetAddress group = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(group);
            System.out.println("Receiver joined multicast group 230.0.0.0 on port 4446.");
            System.out.println("Waiting for messages...");
            
            while (true) {
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                
                String received = new String(packet.getData(), 0, packet.getLength()).trim();
                System.out.println("Received: " + received);
                
                if ("exit".equalsIgnoreCase(received)) {
                    System.out.println("Exit command received. Shutting down receiver.");
                    break;
                }
            }
            socket.leaveGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
