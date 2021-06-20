import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVFile extends CSVMain
{
    private final boolean SUCCESS = true;
    private final boolean FAILURE = false;


    public boolean ReadCSV()
    {
        globalFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        JOptionPane.showMessageDialog
                (null, "PLEASE SELECT A VALID RECORDS FILE");

        //Check if file is CSV format
        int result = globalFile.showOpenDialog(null);

        /************************VALID OPEN FILE CHECK***********************/
        if(result == 1){
            JOptionPane.showMessageDialog(null, "ERROR: PLEASE SELECT A VALID RECORDS FILE");
            return FAILURE;
        }

        file = globalFile.getSelectedFile(); filePath = file.getPath();
        CSVReader reader = null;

        /************************VALID FILE CHECK***********************/
        try { reader = new CSVReader(new FileReader(filePath)); }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,
                    "ERROR: PLEASE SELECT A VALID RECORDS FILE");
            e.printStackTrace();
            return FAILURE;
        }

        /********************VALID FILE WRITE *************************/
        try { globalRecords = reader.readAll(); }
        catch (IOException|CsvException e)
        {
            JOptionPane.showMessageDialog(null,
                    "ERROR: PLEASE SELECT A VALID RECORDS FILE");
            e.printStackTrace();
            return FAILURE;
        }


        return SUCCESS;
    }

}
