package ServerSide;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//Class has capability of running parallel
public class Connection extends Thread
{
    //Parallel functions for Junit Tests
    public void run()
    {
        connect();
    }

    //Creates server connection for client
    public Socket connect()
    {
        ServerSocket serverSocket = null;
        try
        {
            //Client must connect to this port
            serverSocket = new ServerSocket(5000);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Socket connection = null;
        try
        {
            //Waits for client too connect
            connection = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
