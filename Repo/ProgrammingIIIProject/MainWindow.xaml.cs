using System;
using System.Collections.Generic;
using System.Collections;
using System.Linq;
using System.Windows;
using System.IO;

namespace Project
{

    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    /// 

    public partial class MainWindow : Window
    {
        //Binary tree is global allowing Delete and search functions to be updated from the insert method
        BinaryTree tree = new BinaryTree();
        //Create a doubly linked list of strings which is the track list of songs
        LinkedList<string> trackPaths = new LinkedList<string>();
        LinkedList<string> tracks = new LinkedList<string>();
        //Hash table to search from 
        Hashtable myHashTable = new Hashtable();
        //Create a string array to copy the songs into
        string[] playArray = new string[1000];
        bool searchClicked = false;


        public MainWindow()
        {
            InitializeComponent();
            //btnSstart.IsEnabled = false;
            MessageBox.Show("WARNING: Please read the help files before using");
        }

        private void btnSstart_Click(object sender, RoutedEventArgs e)
        {
            myHashTable = new Hashtable();
            trackPaths.Clear();
            tracks.Clear();
            myHashTable.Clear();
            // Create OpenFileDialog
            Microsoft.Win32.OpenFileDialog openFileDlg = new Microsoft.Win32.OpenFileDialog();
            openFileDlg.Filter = "All Media Files|*.wav;*.aac;*.wma;*.wmv;*.avi;*.mpg;*.mpeg;*.m1v;*.mp2;*.mp3;*.mpa;*.mpe;*.m3u;*." +
                "mp4;*.mov;*.3g2;*.3gp2;*.3gp;*.3gpp;*.m4a;*.cda;*.aif;*.aifc;*.aiff;*.mid;*.midi;*.rmi;*.mkv;*.WAV;*.AAC;*" +
                ".WMA;*.WMV;*.AVI;*.MPG;*.MPEG;*.M1V;*.MP2;*.MP3;*.MPA;*.MPE;*.M3U;*.MP4;*.MOV;*.3G2;*.3GP2;*.3GP;*.3GPP;*" +
                ".M4A;*.CDA;*.AIF;*.AIFC;*.AIFF;*.MID;*.MIDI;*.RMI;*.MKV";
            openFileDlg.Multiselect = true;
            // Launch OpenFileDialog by calling ShowDialog method
            Nullable<bool> result = openFileDlg.ShowDialog();
            if (result == true)
            {
                foreach (String filepath in openFileDlg.FileNames)
                {
                    trackPaths.AddFirst(filepath);
                    tracks.AddLast(Path.GetFileName(filepath));
                }

                String[] names = tracks.ToArray();
                //The array is sorted for the create balanced binary tree function which treats the array
                //like numbers in order, sorting the array allows each element to be added balancing the tree
                Array.Sort(names);
                tree.createBalancedTree(names, 1, names.Length);
                tree.SetForSearch(tree.GetRoot());
                tracks.Clear();
                inOrder(tree.returnSearchRoot());
                tree.SetRoot(null);

                for (int kindex = 0; kindex < tracks.Count; kindex++)
                {
                    myHashTable.Add(tracks.ElementAt(kindex), kindex);
                    lbTracks1.Items.Add(tracks.ElementAt(kindex));
                }

                mediaPlayer.Source = new Uri(trackPaths.First.Value);
                mediaPlayer.Play();

            }
            if(result == false)
            {
                MessageBox.Show("Please select valid media file(s)");
            }

        }

        private void btnSave_Click(object sender, RoutedEventArgs e)
        {
            CSVfunctions save = new CSVfunctions();
            save.saveCSV(tracks);
        }

        private void btnSearch_Click(object sender, RoutedEventArgs e)
        {
            string search = txtSearch.Text;
            if (myHashTable[search] == null)
            {
                MessageBox.Show("Search criteria not found");
            }
            else 
            {
                int index = (int)myHashTable[search];
                mediaPlayer.Source = new Uri(trackPaths.ElementAt(index));
                mediaPlayer.Play();
                searchClicked = true;
                lbTracks1.SelectedIndex = index;
                searchClicked = false;
            }

        }

        private void inOrder(TreeNode node)
        {
            if (node == null) { return; }
            inOrder(node.leftNode);
            tracks.AddLast(node.name);
            inOrder(node.rightNode);
        }

        private void lbTracks1_SelectionChanged(object sender, System.Windows.Controls.SelectionChangedEventArgs e)
        {
            if(searchClicked == false)
            {
                var newIndex = e.AddedItems[0];
                string map = newIndex.ToString();
                int index = (int)myHashTable[map];
                mediaPlayer.Source = new Uri(trackPaths.ElementAt(index));
                mediaPlayer.Play();
            }
            
        }
    }
}
