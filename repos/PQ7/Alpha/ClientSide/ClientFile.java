package ClientSide;

import javax.swing.*;
import java.io.File;

public class ClientFile
{
    public String getPath()
    {
        //Select file
        JFileChooser fileChoser = new JFileChooser("."); File file;
        fileChoser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        JOptionPane.showMessageDialog(null,"PLEASE SELECT A SAVE LOCATION");
        //Get file path from user
        int result = fileChoser.showOpenDialog(null);
        file = fileChoser.getSelectedFile(); String path = file.getPath();
        return path;
    }
}
