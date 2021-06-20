package ServerSide;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class UploadFile
{
    public void upload(Socket connection,String path) throws IOException
    {
        //Create a data object to store uploaded data before writing
        FileInputStream fileRead = new FileInputStream(path);
        byte data[] = new byte[5000000];
        fileRead.read(data,0,data.length);
        //Stream manages communication between server and client
        OutputStream outputStream = connection.getOutputStream();
        //Write the file into the server
        outputStream.write(data,0,data.length);
        System.out.println("File upoloaded");
        JOptionPane.showMessageDialog(null,"FILE UPLOADED");
    }
}
