import com.opencsv.CSVWriter;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWrite extends CSVMain
{
    private boolean STATUS = false;
    public List<String[]> getTableInfo(JTable table)
    {
        List<String[]> records = new ArrayList<String[]>();
        TableModel model = table.getModel();
        String[] tempArray = new String[model.getColumnCount()];

        for(int index = 0; index < table.getRowCount(); index++)
        {
            for(int jindex = 0; jindex < table.getColumnCount(); jindex++)
            {
                if((model.getValueAt(index,jindex))== null)
                {
                    tempArray[jindex] = "";
                }
                else
                {
                    tempArray[jindex] = model.getValueAt(index,jindex).toString();
                }
            }
            records.add(index,tempArray);
            tempArray = new String[model.getColumnCount()];
        }

        return records;
    }

    public boolean writeFile(List<String[]> records)
    {
        //Select File
        globalFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        JOptionPane.showMessageDialog
                (null, "PLEASE SELECT A WRITE LOCATION");
        //Check if file is a valid save locataion
        int result = globalFile.showOpenDialog(null);

        /************************VALID OPEN FILE CHECK***********************/
        if(result == 1){
            return STATUS;
        }
        file = globalFile.getSelectedFile(); filePath = file.getPath();

        //Write to file
        try {
            CSVWriter writer = null;
            writer = new CSVWriter(new FileWriter(filePath));
            writer.writeAll(records);
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"ERROR: FILE NOT SAVED");
            JOptionPane.showMessageDialog(null,"Please include file name and extension when saving");
            e.printStackTrace();
            return STATUS;
        }
        return true;

    }


}
