import java.net.InetAddress;
import java.net.Socket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.UnknownHostException;


public class Client {
    public void run() throws UnknownHostException, IOException {
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = null;
        PrintWriter toServer = null;
        BufferedReader fromServer = null;
        try{
            socket = new Socket(address, port);
            toServer = new PrintWriter(socket.getOutputStream(), true);
            fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            toServer.println("Hello from the client!");
            String line = fromServer.readLine();
            System.out.println("Response from the socket is : " + line);
        } finally {
            if (fromServer != null) fromServer.close();
            if (toServer != null) toServer.close();
            if (socket != null) socket.close();
        }
    }

    public static void main(String[] args){
        try{
            Client client = new Client();
            client.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}
