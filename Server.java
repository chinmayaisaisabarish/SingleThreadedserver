import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;



public class Server {
    public void run() throws IOException, UnknownHostException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(20000);
        try {
            while(true){
                Socket acceptedConnection = null;
                PrintWriter toClient = null;
                BufferedReader fromClient = null;
            try{
            System.out.println("Server is listening on port " + port);
            acceptedConnection = socket.accept();
            System.out.println("Connection accepted from  Client " + acceptedConnection.getRemoteSocketAddress());
            toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
            fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            toClient.println("Hello world from the server!");
            }catch(IOException ex){
                ex.printStackTrace();
            }finally{
                if(fromClient != null)
                    fromClient.close();
                if(toClient != null)
                    toClient.close();
                
                if(acceptedConnection != null)
                    acceptedConnection.close();
            }
                
        }
    }finally{
        System.out.println("Closing the server socket");
            socket.close();
    
        }
    }
public static void main(String[] args){
    Server server = new Server();
    try{
        server.run();
    }catch(Exception ex){
        ex.printStackTrace();
    }
}
}

