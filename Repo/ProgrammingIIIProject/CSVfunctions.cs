using System;
using CsvHelper;
using System.IO;
using System.Globalization;
using System.Windows;
using System.Collections.Generic;
using System.Linq;

namespace Project
{
    class CSVfunctions
    {
        public class Data
        {
            //This information is used as columns within the datagrid
            public string songs { get; set; }
        }
        
        public void saveCSV(LinkedList<string> current)
        {
            // Openfile dialog used to open sensor information displaying that information in a table
            Microsoft.Win32.SaveFileDialog saveOpenFileDlg = new Microsoft.Win32.SaveFileDialog();

            // Launch OpenFileDialog by calling ShowDialog method
            string filePathOpen = null;
            saveOpenFileDlg.Filter = "All CSV Files|*.csv";
            Nullable<bool> result = saveOpenFileDlg.ShowDialog();
            if(result == true)
            {
                filePathOpen = saveOpenFileDlg.FileName;
                FileInfo file = new FileInfo(filePathOpen);
                var records = new List<Data> { };
                for (int index = 0; index < current.Count; index++)
                {
                    records.Add(new Data { songs = current.ElementAt(index) });
                }
                //The normal reader is opened to read the filepath
                using (var writer = new StreamWriter(filePathOpen))
                using (var csv = new CsvWriter(writer, CultureInfo.InvariantCulture))
                {
                    csv.WriteRecords(records);
                }
            }
            if(result == false)
            {
                MessageBox.Show("Please select a valid file that contains CSV type format");
            }

        }

    }
}
