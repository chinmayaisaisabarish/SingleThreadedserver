
**Single-Threaded Web Server in Java**

**Overview:**
This project demonstrates a basic single-threaded client-server communication using Java Sockets. The server listens for incoming connections on a fixed port and communicates with one client at a time.

**Files:**

* Server.java – Contains the server-side socket implementation.
* Client.java – Contains the client-side socket implementation.
* Server.class – Compiled version of Server.java.

**Requirements:**

* Java 8 or higher

**How to Compile:**

```
javac Server.java Client.java
```

**How to Run:**

*Run the Server:*

```
java Server
```

*Run the Client (in a separate terminal):*

```
java Client
```

**Functionality:**

* The server binds to port 8010.
* The client connects to localhost on port 8010.
* The client sends a greeting.
* The server responds with a message.
* Both server and client close resources after communication.

**Features:**

* Basic socket communication using Java.
* Server handles one client at a time (single-threaded).
* Uses PrintWriter and BufferedReader for text-based communication.
* Resources are properly closed using try-finally.
* Server socket has a timeout set.

 **Conclusion**
Only one client is handled at a time (no concurrency).
