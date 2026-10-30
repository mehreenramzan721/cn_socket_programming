import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ChatServer{
    public static void main(String[] args){
        
        int port = 5000;
        Scanner scanner = new Scanner(System.in);
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server is waiting on port: " + port);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected : "+ socket.getInetAddress().getHostAddress());
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                while(true){
                    String msg = reader.readLine();
                    if(msg == null || msg.equals('exit')){
                        System.out.println("Client left the chat");
                    break;
                    }
                    System.out.println("Client: "+ msg);
                    System.out.print("You: ");
                    String reply=scanner.nextLine();
                    writer.println(reply);
                    if(reply.equals("exit")){
                        System.out.println("You ended the chat");
                        break;
                    }
                    
                }socket.close();
                    System.out.println("Waiting for the other client");

            }
        }
        catch(IOException e){
            System.out.println("Server Error: "+e.getMessage());
        }
    }
    
}