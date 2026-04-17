import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Exp2RMIAutomatic {
    
    // Remote Interface
    public interface MyRemote extends Remote {
        String sayHello() throws RemoteException;
    }

    // Remote Interface Implementation
    public static class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
        protected MyRemoteImpl() throws RemoteException {}
        public String sayHello() throws RemoteException { 
            return "Server says, 'Hello via automatic RMI!'"; 
        }
    }

    public static void main(String[] args) {
        System.out.println("Experiment 2: Client/Server using RPC/RMI (Automatic)");
        try {
            // Setup Server side in a background thread
            new Thread(() -> {
                try {
                    MyRemote service = new MyRemoteImpl();
                    LocateRegistry.createRegistry(1099);
                    Naming.rebind("rmi://localhost:1099/RemoteHelloAuto", service);
                    System.out.println("RMI Server started automatically.");
                } catch (Exception e) {
                    System.out.println("Server already running or failed. " + e.getMessage());
                }
            }).start();
            
            Thread.sleep(1000); // Give the server a moment to start up
            
            // Setup Client side to automatically connect and call
            MyRemote stub = (MyRemote) Naming.lookup("rmi://localhost:1099/RemoteHelloAuto");
            System.out.println("Client automatically received: " + stub.sayHello());
            
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
