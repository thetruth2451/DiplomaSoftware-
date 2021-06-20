import com.opencsv.CSVReader;

import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class CSVMain
{
    //These are Form elements
    public JTable tblRecords;
    private JPanel MainPannel;
    private JButton btnOpen;
    private JButton btnWrite;

    //Open And Delete variables
    public static String filePath = "";
    public static File file;
    public static JFileChooser globalFile =
            new JFileChooser(".");
    public static List<String[]> globalRecords;
    private static CSVReader reader = null;

    private boolean STATUS = false;
    public boolean populateTable ()
    {
        //index
        int indexy = globalRecords.size() * 2;
        //Variables for displaying table
        String[] columnNames = new String[20];
        columnNames = globalRecords.get(0);
        Object[][] data = new Object[indexy ][50];

        //Assign table headings for table
        for(int yndex = 0; yndex < globalRecords.get(0).length; yndex++)
        { data[0][yndex] = columnNames[yndex]; }
        //populate(data,columnNames);

        //Loop through record information and display
        for(int index = 1; index < globalRecords.size();index++)
        {
            for(int jndex = 0; jndex < globalRecords.get(0).length; jndex++)
            { data[index][jndex] = globalRecords.get(index)[jndex]; }
        }
        tblRecords.setModel(new DefaultTableModel(data,columnNames));
        return true;
    }

    //ACTION LISTENERS
    public CSVMain() {
        //DISPLAY CSV ACTION LISTENER
        btnOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVFile check = new CSVFile();
                STATUS = check.ReadCSV();
                if(STATUS)
                {
                    populateTable();
                }


            }
        });
        //WRITE RECORD ACTION LISTENER
        btnWrite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CSVWrite write = new CSVWrite();
                globalRecords = write.getTableInfo(tblRecords);
                STATUS = write.writeFile(globalRecords);
                if(STATUS){JOptionPane.showMessageDialog(null,"FILE SUCCSESSFULLY WRITTEN");}
                if(!STATUS){JOptionPane.showMessageDialog(null,"ERROR: FILE NOT SAVED");}
            }
        });
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("CSVMain");
        frame.setContentPane(new CSVMain().MainPannel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,400);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(null,"WARNING: PLEASE USE CORRECT WRITE FILE FORMAT!");
        JOptionPane.showMessageDialog(null,"PLEASE VIEW HELP FILES BEFORE OPERATION");
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] input = new String[10];
        for(int index = 0; index < input.length; index++)
        { input[index] = ""; }
        DefaultTableModel model;
        model = new DefaultTableModel(input,10);

        //Disable table user input;
        JTable newJtable = new JTable();
        tblRecords = newJtable;
        tblRecords.setModel(model);
    }
}










