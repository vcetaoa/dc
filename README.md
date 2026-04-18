# Distributed Computing (DC) Lab Practical Experiments

#some other Link:- https://drive.google.com/drive/folders/1GkM8SX-JB6LH6L3vP3354eRKu54N_5On 
This repository contains Java implementations for various Distributed Computing concepts based on the lab practicals. Below is a detailed map of all the experiment files, what they do, why they are structured the way they are, and exactly how to execute them.

---

## Experiment 1: Inter-Process Communication (Sockets)
**Concept**: Low-level, reliable network communication using TCP sockets where a Server binds to a port and a Client sends streams of data to it.

**Why there are 3 files**: We separated the logic into three files so you can see both a completely automated simulation (where threads handle it instantly) and a 'manual' simulation where you can physically test typing out messages across real separate terminals.
* **`Exp1SocketAutomatic.java`**: The one-click automated version. Both the server and client components are housed inside this single file. When executed, it automatically connects its inner client to its inner server and sends a hardcoded message.
* **`Exp1SocketManualServer.java`**: The standalone real-time Server. When run, it waits endlessly for connections on port 5000 and prints any incoming data it catches.
* **`Exp1SocketManualClient.java`**: The standalone real-time Client. When run, this connects to the waiting server and prompts you to type messages into the interactive terminal to send them over.

**How to run**:
* *Automatic:* `javac Exp1SocketAutomatic.java` and then `java Exp1SocketAutomatic`
* *Manual:* Open two separate terminal windows.
  * *Terminal 1:* `javac Exp1SocketManualServer.java` and then `java Exp1SocketManualServer`
  * *Terminal 2:* `javac Exp1SocketManualClient.java` and then `java Exp1SocketManualClient` (Begin typing your messages!)

---

## Experiment 2: Client/Server using RPC/RMI
**Concept**: Remote Method Invocation (RMI). Allows an object existing in one Java Virtual Machine (JVM) to invoke methods on an object residing in another JVM.

**Why there are 3 files**: Similar to Experiment 1, this gives you an automatic demo that instantly finishes, plus manual components that prove the RMI registry works dynamically.
* **`Exp2RMIAutomatic.java`**: The automated logic. The server publishes a method `sayHello()` to the registry, and the nested client thread automatically looks it up and executes it.
* **`Exp2RMIManualServer.java`**: The standalone RMI registry service. It launches on port 1100 and hosts a `sendMessage` remote method.
* **`Exp2RMIManualClient.java`**: The interactive client. It locates the target server and allows you to submit custom string arguments dynamically to process the remote server's function.

**How to run**:
* *Automatic:* `javac Exp2RMIAutomatic.java` and then `java Exp2RMIAutomatic`
* *Manual:* Open two separate terminals.
  * *Terminal 1:* `javac Exp2RMIManualServer.java` and then `java Exp2RMIManualServer`
  * *Terminal 2:* `javac Exp2RMIManualClient.java` and then `java Exp2RMIManualClient`

---

## Experiment 3: Group Communication (Multicast)
**Concept**: Multicasting allows one node to systematically transmit Datagram UDP broadcasts simultaneously to multiple subscribed hosts over a shared IP group.

**Why there are 3 files**: This is split up to demonstrate how one sender affects entirely separate receiver processes dynamically, but also gives the hassle-free fully programmed alternative. 
* **`Exp3AutomaticMulticast.java`**: An automated setup tying a single Multicast listener to a UDP datagram sender internally, triggering an instant exchange across IP `230.0.0.0`.
* **`Exp3ManualReceiver.java`**: A standalone node that binds to `230.0.0.0:4446` and constantly listens in real-time for any messages published to the group.  
* **`Exp3ManualSender.java`**: An interactive node that takes your terminal inputs and rapidly broadcasts them out to all connected listener nodes on that IP configuration.

**How to run**:
* *Automatic:* `javac Exp3AutomaticMulticast.java` and then `java Exp3AutomaticMulticast`
* *Manual:* Open two terminals.
  * *Terminal 1:* `javac Exp3ManualReceiver.java` and then `java Exp3ManualReceiver` *(Tip: You can open multiple receivers in multiple terminal windows!)*
  * *Terminal 2:* `javac Exp3ManualSender.java` and then `java Exp3ManualSender` 

---

## Experiment 5: Election Algorithms 
**Concept**: Simulating how logical arrays elect a new central Coordinator if the current Master node crashes. 
* **`Exp5RingElection.java`**: Demonstrates the **Ring Algorithm**—nodes are logical neighbors. They pass an election packet continuously in a circle, finding the highest remaining active node ID in the sequence.
* **`Exp5BullyElection.java`**: Demonstrates the **Bully Algorithm**—the detecting node attempts to bypass lower nodes and directly blasts election notices to nodes with strictly higher IDs. The highest answering node "bullies" everyone else and claims dominance.

**How to run**:
* *Ring Algorithm:* `javac Exp5RingElection.java` and then `java Exp5RingElection` 
* *Bully Algorithm:* `javac Exp5BullyElection.java` and then `java Exp5BullyElection`
*(Follow the interactive console menu prompts to define crashed hosts and election triggers)*

---

## Experiment 6: Token Ring Mutual Exclusion Algorithm
**Concept**: Preventing critical resource congestion by circulating an arbitrary "token". A node cannot run its critical process sequence unless it physically holds the token.
* **`Exp6TokenRingMutualExclusion.java`**: Automatically simulates a 5-node ring. Requests a node ID from you that wants critical access, and then animates exactly how the token traverses neighboring systems iteratively until your specified process receives it.

**How to run**:
* `javac Exp6TokenRingMutualExclusion.java` and then `java Exp6TokenRingMutualExclusion`

---

## Experiment 8: Task Assignment Approach
**Concept**: Resource routing logic. Given scattered execution/computation costs across processors logically, the software calculates the cheapest route to parallel-process a task set.
* **`Exp8TaskAssignment.java`**: Executes the cost-minimization logic instantaneously using hard-coded mathematical tables embedded directly in the java code.
* **`Exp8TaskAssignmentUserInput.java`**: A fully interactive version. It prompts you to manually define the amount of tasks, amount of processors, and dynamically input your own metrics to build out the entire execution cost grid!

**How to run**:
* *Hardcoded values:* `javac Exp8TaskAssignment.java` and then `java Exp8TaskAssignment`
* *Your Inputs:* `javac Exp8TaskAssignmentUserInput.java` and then `java Exp8TaskAssignmentUserInput`
