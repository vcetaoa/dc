import java.net.*;
import java.io.*;

public class Exp3AutomaticMulticast {
    public static void main(String[] args) {
        System.out.println("Experiment 3: Group Communication (Multicast) - Automatic");
        
        Thread receiver = new Thread(() -> {
            try (MulticastSocket socket = new MulticastSocket(4446)) {
                InetAddress group = InetAddress.getByName("230.0.0.0");
                socket.joinGroup(group);
                
                byte[] buf = new byte[256];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                System.out.println("Receiver joined group 230.0.0.0 and waiting...");
                socket.receive(packet);
                
                String received = new String(packet.getData(), 0, packet.getLength()).trim();
                System.out.println("Multicast Receiver got: " + received);
                socket.leaveGroup(group);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread sender = new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket()) {
                InetAddress group = InetAddress.getByName("230.0.0.0");
                byte[] buf = "Hello Multicast Group!".getBytes();
                
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                System.out.println("Sender sending message to group 230.0.0.0...");
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        receiver.start();
        
        try {
            Thread.sleep(500); 
        } catch (Exception ignored) {}
        
        sender.start();
    }
}
