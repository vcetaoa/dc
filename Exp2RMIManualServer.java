import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Exp2RMIManualServer {
    
    // Public nested Remote interface so the client can find it
    public interface MyManualRemote extends Remote {
        String sendMessage(String msg) throws RemoteException;
    }

    // Implementation of the remote interface
    public static class MyManualRemoteImpl extends UnicastRemoteObject implements MyManualRemote {
        protected MyManualRemoteImpl() throws RemoteException {}
        
        public String sendMessage(String msg) throws RemoteException {
            System.out.println("Client typed: " + msg);
            return "Server acknowledged: '" + msg + "'";
        }
    }

    public static void main(String[] args) {
        System.out.println("Experiment 2: Manual RMI Server");
        try {
            MyManualRemote service = new MyManualRemoteImpl();
            // Using port 1100 to avoid conflicting with the Automatic version if both run unexpectedly
            LocateRegistry.createRegistry(1100);
            Naming.rebind("rmi://localhost:1100/RemoteHelloManual", service);
            System.out.println("Manual RMI Server started on port 1100 and is waiting for client messages...");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Failed to start Manual RMI Server.");
        }
    }
}
