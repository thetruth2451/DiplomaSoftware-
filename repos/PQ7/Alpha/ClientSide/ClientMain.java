package ClientSide;

import java.net.Socket;


public class ClientMain {

    public static void main(String[] args) throws Exception
    {
        //connection
        Socket clientSocket = new Socket("127.0.0.1",5000);
        //Select file
        ClientFile client = new ClientFile();
        String path = client.getPath();
        //Download file
        Download download = new Download();
        download.download(clientSocket, path);


    }
}
