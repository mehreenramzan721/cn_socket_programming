import java.io.*;
import java.net.*;

public class TimeClient{
    public static void main(String[] args){
        if(args.length<2) return ;
        String hostname= args[0];
        int port = Integer.parseInt(args[1]);
        try(Socket socket = new Socket(hostname, port)){
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String time = reader.readLine();
            System.out.println(time);
        }
        catch(UnknownHostException ex ){
            System.out.println("Server not found :"+ ex.getMessage());

        }
        catch(IOException ex){
            System.out.println("IO :" + ex.getMessage());
        }
    }
}