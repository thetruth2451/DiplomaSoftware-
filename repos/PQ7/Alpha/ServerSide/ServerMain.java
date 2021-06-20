package ServerSide;

import java.net.Socket;

public class ServerMain
{
    public static void main(String[] args) throws Exception
    {

        //Connection
        Connection connection = new Connection();
        Socket connect = connection.connect();
        //Select File
        ServerFile serverFile = new ServerFile();
        String path = serverFile.getPath();
        //Transfer file
        UploadFile uploadfile = new UploadFile();
        uploadfile.upload(connect,path);

    }
}
