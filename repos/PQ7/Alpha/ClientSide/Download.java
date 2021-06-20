package ClientSide;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Download
{
    public void download(Socket clientSocket, String path) throws IOException
    {
        String truepath = path;
        //Create a data object to store downloaded data before writing
        byte data[] = new byte[5000000];
        //Stream manages communication between server and client
        InputStream inputStream = clientSocket.getInputStream();
        FileOutputStream fileOutputStream2 = new FileOutputStream(path);
        inputStream.read(data,0,data.length);
        //Read the file from the server
        fileOutputStream2.write(data,0, data.length);
        System.out.println("File downloaded");
        JOptionPane.showMessageDialog(null,"FILE DOWNLOADED");
    }
}
